package com.javapro.cloudservice.dao.impl;

import com.javapro.cloudservice.dao.FilesDao;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
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
    public List<Files> getFiles(String nickname, int parentid) {
        users=(Users) entityManager.createQuery("select c from Users c where c.nickname=:nickname").setParameter("nickname",nickname).getSingleResult();
        Folders folders = (Folders) entityManager.createQuery("select c from Folders c where c.id=:parentid and c.userId=:userid").setParameter("parentid",parentid).
                setParameter("userid",users.getId()).getSingleResult();
        List<Files> listfiles= folders.getFilesById();
        return listfiles;
    }
    @Override
    public void deleteFile(String name,String parentfolder,String foldername,int userid) {
        Folders folders = (Folders) entityManager.createQuery("select c from Folders c where c.name=:folder and c.parentfolder=:parentfolder and c.userId=:userid").setParameter("folder",foldername)
                .setParameter("parentfolder",parentfolder).setParameter("userid",userid).getSingleResult();
        Files file= (Files) entityManager.createQuery("select c from Files c where c.name=:name and c.folderId=:folderid and c.userId=:userid")
                .setParameter("name",name).setParameter("folderid",folders.getId()).setParameter("userid",userid).getSingleResult();
        file.setFolderId(0);
        entityManager.merge(file);
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
