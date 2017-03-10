package com.javapro.cloudservice.utils.impl;

import com.javapro.cloudservice.utils.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

/**
 * Created by Oleg on 13.02.2017.
 */

@Component
public class FileUtilsImpl implements FileUtils {
  //  private File dir=new File("D:\\CloudUsers\\");
//изменить
        public void uploadFile(String dir,MultipartFile multipartFile) {
        File file= new File(dir);
            file.getAbsolutePath();
            System.out.println(multipartFile.getOriginalFilename());
        try (BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()))){
            byte[] bytes=multipartFile.getBytes();
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //В контроллере сделать mimetype
        public void downloadFile(String dir,OutputStream outputStream) {
           File file = new File(dir);
            try(InputStream inputStream = new FileInputStream(file.getAbsolutePath())) {

                IOUtils.copy(inputStream, outputStream);

            } catch (IOException e){
                e.printStackTrace();
            }
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
