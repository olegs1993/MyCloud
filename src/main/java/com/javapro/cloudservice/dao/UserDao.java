package com.javapro.cloudservice.dao;

import com.javapro.cloudservice.entities.Users;

/**
 * Created by Oleg on 22.02.2017.
 */
public interface UserDao {
    void addUser(String name, String password);
    Users getUser(String nickname);
}
