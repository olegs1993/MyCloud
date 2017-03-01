package com.javapro.cloudservice.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

/**
 * Created by Oleg on 13.02.2017.
 */
public interface FileUtils {
     void  uploadFile(String dir, MultipartFile file);
     void  downloadFile(String dir, OutputStream outputStream);
     boolean createDirectory(String dir);
     boolean delateDirectory(String dir);

}
