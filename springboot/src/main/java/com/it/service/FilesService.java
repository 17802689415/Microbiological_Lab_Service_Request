package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.it.pojo.Files;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
public interface FilesService extends IService<Files> {
    Files upload(MultipartFile file);
    void download(String fileUUID, HttpServletResponse response);
    
}
