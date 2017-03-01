package com.javapro.cloudservice.dao;

import com.javapro.cloudservice.entities.Files;
import java.util.List;

/**
 * Created by Oleg on 22.02.2017.
 */
public interface FilesDao {
    List<Files> getFiles(String nickname, String folder);
    Files deleteFile(String name);
    void addFiles(String name, String nickname, String folder);
}
