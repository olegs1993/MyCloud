package com.javapro.cloudservice.service.impl;


import com.javapro.cloudservice.dao.FilesDao;
import com.javapro.cloudservice.dao.FolderDao;
import com.javapro.cloudservice.dao.UserDao;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import com.javapro.cloudservice.service.Service;
import com.javapro.cloudservice.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * Created by Oleg on 23.02.2017.
 */
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    UserDao userDao;
    @Autowired
    FolderDao folderDao;
    @Autowired
    FileUtils fileUtils;
    @Autowired
    FilesDao filesDao;
    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public void addUser(String name, String password) {
        userDao.addUser(name,password);
        folderDao.addMainFolder(name);
        fileUtils.createDirectory("D:\\CloudUsers\\"+name);
    }
    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public void addFolder(String name, String parentfolder) {
       folderDao.addFolder(name,parentfolder);
    }
    //Может переписать!!!!!
    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public void addFiles(String name, String nickname, String folder,MultipartFile multipartFile) {
        filesDao.addFiles(name,nickname,folder);
        fileUtils.uploadFile("D:\\CloudUsers\\"+nickname,multipartFile );
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Files> getFiles(String name, String folder) {
        return filesDao.getFiles(name,folder);
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Folders> getFolders(String name) {
        return folderDao.getFolders(name);
    }

    @Override
    public Users getUser(String nickname) {
        return userDao.getUser(nickname);
    }
}
