package com.javapro.cloudservice.service.impl;


import com.javapro.cloudservice.dao.FilesDao;
import com.javapro.cloudservice.dao.FolderDao;
import com.javapro.cloudservice.dao.UserDao;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import com.javapro.cloudservice.service.Service;
import com.javapro.cloudservice.utils.FileUtils;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
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

    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    @Override
    public void addUser(String name, String password) {
        userDao.addUser(name,password);
        folderDao.addMainFolder(name);
        fileUtils.createDirectory("D:\\CloudUsers\\"+name);
    }

    @Override
    public Folders getMainFolder(String name) {
        return folderDao.getMainFolder(name);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addFolder(String name, int parentfolder) {
        folderDao.addFolder(name,parentfolder);
    }
    //Может переписать!!!!!
    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public void addFiles(String name, String nickname, String folder,MultipartFile multipartFile) throws IOException {
        filesDao.addFiles(name,nickname,folder);
        fileUtils.uploadFile("D:\\CloudUsers\\"+nickname+"\\"+name,multipartFile );
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Files> getFiles(String name, int parentid) {

        return filesDao.getFiles(name,parentid);
    }
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<Folders> getFolders(int parentid) {
        return folderDao.getFolders(parentid);
    }

    @Override
    public Users getUser(String nickname) {
        return userDao.getUser(nickname);
    }

    @Override
    public void downloadFile(String filname, String nickname, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        fileUtils.downloadFile("D:\\CloudUsers\\"+nickname+"\\"+filname,httpServletRequest,httpServletResponse);
    }
   /* @Transactional
    @Override
    public void deleteFolder(String name, String parentfolder, int id) {
        folderDao.deleteFolder(name,parentfolder,id);
    }
    @Transactional
    @Override
    public void deleteFile(String name, String parentfolder,String foldername, int id) {
        filesDao.deleteFile(name,parentfolder,foldername,id);
    }*/
}
