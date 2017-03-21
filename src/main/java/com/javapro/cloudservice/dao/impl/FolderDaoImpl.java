package com.javapro.cloudservice.dao.impl;

import com.javapro.cloudservice.dao.FolderDao;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Oleg on 18.02.2017.
 */
@Repository
public class FolderDaoImpl implements FolderDao {

    Users users;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Folders> getFolders(int parentid) {
        Query typedQuery = entityManager.createQuery("SELECT c from Folders c where c.parentfolder=:parentid");
        typedQuery.setParameter("parentid", parentid);
        List<Folders> foldersList= typedQuery.getResultList();
        return foldersList;
    }

    @Override
    public void addMainFolder(String name){
        Folders folders=new Folders();
        folders.setName(name);
        users= (Users) entityManager.createQuery("select c from Users c where c.nickname=:name").setParameter("name",name).getSingleResult();
        folders.setUsersByUserId(users);
        folders.setParentfolder(87);
        entityManager.persist(folders);
    }
    @Override
    public void deleteFolder(String name,int parentid,int id) {
        Folders parfolder = (Folders) entityManager.createQuery("select c from Folders c where c.name=:name and c.parentfolder=:parentid and c.userId=:userid ").setParameter("name",name)
                .setParameter("parentid",parentid).setParameter("userid",id).getSingleResult();
        parfolder.setParentfolder(0);
        entityManager.merge(parfolder);
    }
    @Transactional
    @Override
    public void addFolder(String name,int parentid)  {
        Folders folders=new Folders();
        folders.setName(name);
        Folders parfolder = (Folders) entityManager.createQuery("select c from Folders c where c.id=:parentid").setParameter("parentid",parentid).getSingleResult();
        folders.setUsersByUserId(parfolder.getUsersByUserId());
        folders.setParentfolder(parfolder.getId());
        entityManager.persist(folders);
    }
    @Override
    public Folders getMainFolder(String name) {
        Folders folder=entityManager.createQuery("SELECT c from Folders c where c.name=:name",Folders.class).setParameter("name",name).getSingleResult();
        return folder;
    }


}
