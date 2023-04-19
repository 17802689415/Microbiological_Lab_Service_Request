package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.mapper.CleanroomTestInfoMapper;
import com.it.mapper.FilesMapper;
import com.it.pojo.CleanroomTestInfo;
import com.it.pojo.Files;
import com.it.service.CleanroomTestInfoService;
import com.it.service.FilesService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Service
public class FilesServiceImpl extends ServiceImpl<FilesMapper,Files> implements FilesService{

    private String filesUploadPath="./src/main/resources/file";

    @Override
    public Files upload(MultipartFile file) {
        //将相对路径转化为绝对路径
        String destPath = new File(filesUploadPath).getAbsolutePath();
        //文件夹路径名称
        String originalFilename = file.getOriginalFilename();
        //文件大小
        double size = file.getSize();
        //文件类型
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

        //使用uuid生成随机唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //新的文件名称，uuid+文件类型
        String fileUuid = uuid + "." + type;
        //新的文件地址，绝对路径+新的文件名称
        File uploadFile = new File(destPath + "/" + fileUuid);

        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        try {
            String url;
            //获取文件的md5,通过对比文件md5，防止上传相同内容的文件
            String md5 = DigestUtils.md5DigestAsHex(file.getInputStream());
            //通过MD5来查询文件
            Files dbFiles = this.getFileByMD5(md5);
            if (dbFiles != null) {//如果数据库存在相同文件，直接获取url
                url = dbFiles.getUrl();
            } else {//如果数据库不存在相同文件，先存储到本地磁盘，再设置文件url
                file.transferTo(uploadFile);//把获取到的文件存储带磁盘目录
                url = "http://localhost:8099/lab/" + fileUuid;//设置文件url
            }

            //将文件存储到数据库
            Files saveFile = new Files();
            saveFile.setFilesName(originalFilename);
            saveFile.setType(type);
            saveFile.setSize(size / 1024);//（单位：KB）
            saveFile.setUrl(url);
            saveFile.setMd5(md5);
            //保存操作
            save(saveFile);

            //返回文件下载路径url
            return saveFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //将文件以流的形式一次性读取到内存，通过响应输出流输出到前端
    @Override
    public void download(String filesUUID, HttpServletResponse response) {
        try {
            //根据文件的唯一标识码获取文件
            File uploadFile = new File(filesUploadPath + filesUUID);

            //读取文件的字节流
            FileInputStream fileInputStream = new FileInputStream(uploadFile);
            //将文件写入输入流
            InputStream inputStream = new BufferedInputStream(fileInputStream);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();



            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.png"
            //filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filesUUID, "UTF-8"));
            response.setContentType("application/octet-stream");

            //设置输出流的格式
            ServletOutputStream os = response.getOutputStream();
            os.write(buffer);

            //关闭
            fileInputStream.close();
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过文件MD5查询文件
    private Files getFileByMD5(String md5) {
        //查找数据库是否已经存在一样的图片
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<Files> filesList = list(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }
}

