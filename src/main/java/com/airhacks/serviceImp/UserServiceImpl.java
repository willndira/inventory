/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.serviceImp;

import com.airhacks.models.User;
import com.airhacks.config.JpaUtil;
import com.airhacks.service.UserService;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author william
 */
public class UserServiceImpl implements UserService {

    private JpaUtil jpaUtil;

    public UserServiceImpl() {
        jpaUtil = new JpaUtil();
    }

    @Override
    public void saveUser(User user) {

        EntityManager em = jpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        JpaUtil.closeFactory();
    }

    @Override
    public User getUser(long userId) {
        EntityManager em = jpaUtil.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    @Override
    public List<User> getUsers() {
        EntityManager em = jpaUtil.getEntityManager();
        List<User> users = em.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public void updateUser(User user) {
        User u = getUser(user.getUserId());
        if (u != null) {
            EntityManager em = jpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            em.close();
            JpaUtil.closeFactory();
        }
    }

}
