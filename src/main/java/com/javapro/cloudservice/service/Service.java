package com.javapro.cloudservice.service;

import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Oleg on 23.02.2017.
 */
public interface Service {
    public void addUser(String name, String password);
    public void addFolder(String name, String parentfolder);
    public void addFiles(String name, String nickname, String folder, MultipartFile multipartfile);
    public List<Files> getFiles(String name, String folder);
    public List<Folders> getFolders(String name);
}
