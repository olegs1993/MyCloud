package com.javapro.cloudservice.service;

import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Oleg on 23.02.2017.
 */
public interface Service {
    public void addUser(String name, String password);
    Folders getMainFolder(String name);
    public void addFolder(String name, int parentfolder);
    public void addFiles(String name, String nickname, String folder, MultipartFile multipartfile) throws IOException;
    public List<Files> getFiles(String name, int parentfolder);
    public List<Folders> getFolders(int parentid);
    Users getUser(String nickname);
    public void downloadFile(String filename, String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
  /*  void deleteFolder(String name, int parentfolder, int id);
    void deleteFile(String name,   int parentfolder,String foldername, int id);*/

}
