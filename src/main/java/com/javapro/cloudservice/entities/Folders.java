package com.javapro.cloudservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oleg on 18.02.2017.
 */
@Entity
@Table(name = "\"Folders\"")
public class Folders {
    private int id;
    private int parentfolder;
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
    @Column(name = "parentfolder", nullable = true)
    public int getParentfolder() {
        return parentfolder;
    }

    public void setParentfolder(int parentfolder) {
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


    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "foldersByFolderId")
    public List<Files> getFilesById() {
        return filesById;
    }

    public void setFilesById(List<Files> filesById) {
        this.filesById = filesById;
    }
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
