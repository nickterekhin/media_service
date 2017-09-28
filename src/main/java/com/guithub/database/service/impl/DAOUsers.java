package com.guithub.database.service.impl;

import com.guithub.database.service.DAOService;
import com.guithub.database.service.IDAOUsers;
import com.guithub.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
@Component
public class DAOUsers extends DAOService implements IDAOUsers {

    @Override
    public User save(User obj) {
        return this.daoRepositories.getUserRepository().saveAndFlush(obj);
    }

    @Override
    public void delete(User obj) {

    }

    @Override
    public User getById(long id) {
        return  this.daoRepositories.getUserRepository().findOne(id);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User archive(long Id, boolean archive) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return this.daoRepositories.getUserRepository().findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return this.daoRepositories.getUserRepository().findByEmail(email);
    }

    @Override
    public boolean checkUserInfo(String userName, String email) throws Exception {
        User u = null;
        if(userName!=null)
        {
            u = this.findByUsername(userName);
            if(u!=null)
                throw new Exception("UserName already exists");
        }
        if(email!=null)
        {
            u = this.findByEmail(email);
            if(u!=null)
                throw new Exception("Email already exists");
        }

        return true;
    }

    @Override
    public User checkUserNameAndPassword(String userName,String password,boolean crypt) {
        User user = this.daoRepositories.getUserRepository().findByUsernameAndActive(userName,true);
        if(user==null)
            return null;
        try {
            if(crypt)
                password = DigestUtils.md5Hex(password);

            if (password.equals(user.getPassword())) {
                return user;
            } else {
                return null;
            }
        } catch (Exception exception) {
            return null;
        }
    }
}
