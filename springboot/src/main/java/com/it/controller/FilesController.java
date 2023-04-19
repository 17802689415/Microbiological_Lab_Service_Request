package com.it.controller;

import com.it.pojo.Files;
import com.it.pojo.SampleTestInfo;
import com.it.service.FilesService;
import com.it.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lab")
public class FilesController {
    @Autowired
    private FilesService filesService;

    @PostMapping("/upload")
    @ResponseBody
    public R<Files> upload(MultipartFile file){

        System.out.println(file);
        Files files = filesService.upload(file);
        return R.success(files,1);
    }

    @GetMapping("/{filesUUID}")
    public void download(@PathVariable String filesUUID, HttpServletResponse response){
        filesService.download(filesUUID,response);
    }
}
