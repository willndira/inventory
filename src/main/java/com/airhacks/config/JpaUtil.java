/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author william
 */
public class JpaUtil {

    public static final String persistenceFile = "alphas";
    private static EntityManagerFactory entityManagerFactory;

    public JpaUtil() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceFile);
        }
    }

    public EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();

    }

    public static void closeFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }

    }

}
