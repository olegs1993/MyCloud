package com.javapro.cloudservice.dao;

import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;

import java.util.List;

/**
 * Created by Oleg on 18.02.2017.
 */
public interface FolderDao {
     List<Folders> getFolders(int parentid);
     void addMainFolder(String name);
     void deleteFolder(String name, int parentid, int id);
     void addFolder(String name, int parentid);
    Folders getMainFolder(String name);

}
