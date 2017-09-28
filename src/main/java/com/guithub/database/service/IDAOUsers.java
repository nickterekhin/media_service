package com.guithub.database.service;

import com.guithub.domain.User;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOUsers extends IDAOService<User> {
    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserInfo(String userName, String email) throws Exception;

    User checkUserNameAndPassword(String userName,String password, boolean crypt);

}
