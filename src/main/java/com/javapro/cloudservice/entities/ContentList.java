package com.javapro.cloudservice.entities;

import java.util.List;

/**
 * Created by Oleg on 12.03.2017.
 */
public class ContentList {
    List<Folders> foldersList;
    List<Files> filesList;

    public List<Folders> getFoldersList() {
        return foldersList;
    }

    public void setFoldersList(List<Folders> foldersList) {
        this.foldersList = foldersList;
    }

    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }
}
