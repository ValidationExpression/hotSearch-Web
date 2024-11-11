package com.haolan.hotsearchweb.controller;

import com.haolan.hotsearchweb.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传功能
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        // 获取上传文件原始名称
        String originalFilename = file.getOriginalFilename();
        // 由于会有文件名重复，所以需要给文件重新命名，使用UUID的方式+原始文件后缀名
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf(".")).toString();
        // 将文件存储到本地磁盘中
        file.transferTo(new File("D:\\项目文件\\file\\" + fileName));
        return Result.success("url");
    }
}
