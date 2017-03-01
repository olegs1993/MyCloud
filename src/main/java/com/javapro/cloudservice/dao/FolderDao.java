package com.javapro.cloudservice.dao;

import com.javapro.cloudservice.entities.Folders;
import java.util.List;

/**
 * Created by Oleg on 18.02.2017.
 */
public interface FolderDao {
     List<Folders> getFolders(String name);
     void addMainFolder(String name);
     void deleteFolder(String name);
     void addFolder(String name, String parentfolder);
    Folders getMainFolder(String name);

}
