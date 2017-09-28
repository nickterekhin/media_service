package com.guithub.database.service;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOService<T> {

     T save(T obj);

     void delete(T obj);

    T getById(long id);

    List<T> getAll();

    T archive(long Id, boolean archive);

}
