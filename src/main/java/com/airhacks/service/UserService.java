/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.service;

import com.airhacks.models.User;
import java.util.List;

/**
 *
 * @author william
 */
public interface UserService {

    User getUser(long userId);

    List<User> getUsers();

    void saveUser(User user);

    void updateUser(User user);

}
