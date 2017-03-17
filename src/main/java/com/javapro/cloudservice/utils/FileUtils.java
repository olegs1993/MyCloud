package com.javapro.cloudservice.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Oleg on 13.02.2017.
 */
public interface FileUtils {
     void  uploadFile(String dir, MultipartFile file) throws IOException;
     void  downloadFile(String dir, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
     boolean createDirectory(String dir);
     boolean delateDirectory(String dir);

}
