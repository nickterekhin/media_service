package com.guithub.database.service.impl;

import com.guithub.database.service.DAOService;
import com.guithub.database.service.IDAOProject;
import com.guithub.domain.Project;
import com.guithub.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
@Component
public class DAOProject extends DAOService implements IDAOProject {


    @Override
    public Project getById(long id, boolean active) {

        return this.daoRepositories.getProjectRepository().findProjectByIdAndActive(id,active);
    }

    @Override
    public Project findProjectByProjectNameAndUser(String projectName, User user, boolean archived) {

        return null;
    }

    @Override
    public Project findProjectByProjectNameAndUser(String projectName, User user) {
        return this.findProjectByProjectNameAndUser(projectName,user,false);
    }

    @Override
    public Project save(Project obj) {
        return this.daoRepositories.getProjectRepository().saveAndFlush(obj);
    }

    @Override
    public void delete(Project obj) {

    }

    @Override
    public Project getById(long id) {
        return getById(id,false);
    }

    @Override
    public List<Project> getAll() {
        return this.daoRepositories.getProjectRepository().findAll();
    }

    @Override
    public Project archive(long Id, boolean archive) {
        Project p = this.getById(Id);

        //p.setArchived(archive);
        return this.save(p);
    }
}
