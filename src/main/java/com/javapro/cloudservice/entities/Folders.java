package com.javapro.cloudservice.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oleg on 18.02.2017.
 */
@Entity
@Table(name = "\"Folders\"")
public class Folders {
    private int id;
    private String parentfolder;
    private int userId;
    private String name;
    private List<Files> filesById;
    private Users usersByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "id_auto_folders",allocationSize = 1)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parentfolder", nullable = true, length = 255)
    public String getParentfolder() {
        return parentfolder;
    }

    public void setParentfolder(String parentfolder) {
        this.parentfolder = parentfolder;
    }

    @Basic
    @Column(name = "user_id", nullable = true,insertable = false,updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Folders folders = (Folders) o;

        if (id != folders.id) return false;
        if (userId != folders.userId) return false;
        if (parentfolder != null ? !parentfolder.equals(folders.parentfolder) : folders.parentfolder != null)
            return false;
        if (name != null ? !name.equals(folders.name) : folders.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (parentfolder != null ? parentfolder.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "foldersByFolderId")
    public List<Files> getFilesById() {
        return filesById;
    }

    public void setFilesById(List<Files> filesById) {
        this.filesById = filesById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
