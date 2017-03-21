package com.javapro.cloudservice.utils.impl;

import com.javapro.cloudservice.utils.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Oleg on 13.02.2017.
 */
@Component
public class FileUtilsImpl implements FileUtils {
        public void uploadFile(String dir,MultipartFile multipartFile) throws IOException {
        File file= new File(dir);
            file.getAbsolutePath();
            System.out.println(multipartFile.getOriginalFilename());
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()));
            byte[] bytes=multipartFile.getBytes();
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();

    }
        public void downloadFile(String dir, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
           File file = new File(dir);
            MultipartFileSender.fromPath(file.toPath()).with(httpServletRequest).with(httpServletResponse).serveResource();
        }
    @Override
    public boolean createDirectory(String dir) {
        File folder=new File(dir);
        return folder.mkdir();
    }
    @Override
    public boolean delateDirectory(String dir) {
       File folder=new File(dir);
        return folder.delete();
    }


}
