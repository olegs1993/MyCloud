package com.javapro.cloudservice.dao.impl;

import com.javapro.cloudservice.dao.FilesDao;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Oleg on 22.02.2017.
 */
@Repository
public class FilesDaoImpl implements FilesDao {
    Users users;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Files> getFiles(String nickname, String folder) {
        users=(Users) entityManager.createQuery("select c from Users c where c.nickname=:nickname").setParameter("nickname",nickname).getSingleResult();
        Folders folders = (Folders) entityManager.createQuery("select c from Folders c where c.name=:folder and c.userId=:userid").setParameter("folder",folder).
                setParameter("userid",users.getId()).getSingleResult();
        List<Files> listfiles= folders.getFilesById();
        return listfiles;
    }

    @Override
    public Files deleteFile(String name) {
        return null;
    }

    @Override
    public void addFiles(String name, String nickname, String folder) {
        Files files=new Files();
        files.setName(name);
        users= (Users) entityManager.createQuery("select c from Users c where c.nickname=:nickname").setParameter("nickname",nickname).getSingleResult();
        files.setUserId(users.getId());
        Folders folders = (Folders) entityManager.createQuery("select c from Folders c where c.name=:folder and c.userId=:userid").setParameter("folder",folder)
                .setParameter("userid",users.getId()).getSingleResult();
        files.setFolderId(folders.getId());
        files.setDirectory("D:\\CloudUsers\\"+nickname);
        entityManager.persist(files);
    }
}
