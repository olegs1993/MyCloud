package com.javapro.cloudservice.dao.impl;

import com.javapro.cloudservice.dao.UserDao;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Oleg on 22.02.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addUser(String name, String password) {
        Users users=new Users();
        users.setNickname(name);
        users.setPassword(password);
        users.setDirectory("D:\\CloudUsers\\"+name);
        entityManager.persist(users);
    }

    @Override
    public Users getUser(String nickname) {
        return entityManager.createQuery("SELECT c from Users c where c.nickname=:nickname",Users.class).setParameter("nickname",nickname).getSingleResult();
    }
}
