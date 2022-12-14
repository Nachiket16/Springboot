package com.nachiket.blog.services.impl;

import com.nachiket.blog.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //File Name
        String name = file.getOriginalFilename();

        //File Path
        String filePath=path+name;

        //create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //file copy
//        Files.copy(file.getInputStream(), Paths.get(filePath));
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return name;

    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path+fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
