package com.guithub.database.service;

import com.guithub.domain.Project;
import com.guithub.domain.User;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOProject extends IDAOService<Project> {

    Project getById(long id, boolean archived);
    Project findProjectByProjectNameAndUser(String projectName, User user, boolean archived);
    Project findProjectByProjectNameAndUser(String projectName, User user);
}
