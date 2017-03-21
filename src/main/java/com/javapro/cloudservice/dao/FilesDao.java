package com.javapro.cloudservice.dao;

import com.javapro.cloudservice.entities.Files;
import java.util.List;

/**
 * Created by Oleg on 22.02.2017.
 */
public interface FilesDao {
    List<Files> getFiles(String nickname, int parentid);
    void deleteFile(String name,String parentfolder,String foldername,int userid);
    void addFiles(String name, String nickname, String folder);
}
