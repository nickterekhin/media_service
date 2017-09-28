package com.guithub.database.service;

import com.guithub.database.repository.impl.DAORepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Nick on 20.05.17.
 */
@Component
public abstract  class DAOService {
    @Autowired
    protected DAORepositories daoRepositories;

    protected String md5(String str)
    {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = str.getBytes();
            m.update(data,0,data.length);
            BigInteger i = new BigInteger(1,m.digest());
            return i.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
