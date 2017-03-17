package com.javapro.cloudservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by Oleg on 18.02.2017.
 */
@Entity
@Table(name = "\"Files\"")
public class Files {
    private int id;
    private String name;
    private int folderId;
    private String directory;
    private int userId;
    private Folders foldersByFolderId;
    private Users usersByUserId;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "id_auto_files",allocationSize = 1)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "folder_id", nullable = true)
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    @Basic
    @Column(name = "directory", nullable = true, length = 255)
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Files files = (Files) o;

        if (id != files.id) return false;
        if (folderId != files.folderId) return false;
        if (userId != files.userId) return false;
        if (name != null ? !name.equals(files.name) : files.name != null) return false;
        if (directory != null ? !directory.equals(files.directory) : files.directory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + folderId;
        result = 31 * result + (directory != null ? directory.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "folder_id", referencedColumnName = "id",insertable = false,updatable = false)
    public Folders getFoldersByFolderId() {
        return foldersByFolderId;
    }

    public void setFoldersByFolderId(Folders foldersByFolderId) {
        this.foldersByFolderId = foldersByFolderId;
    }
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false,updatable = false)
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }


}
