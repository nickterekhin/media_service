package com.guithub.database.service.impl;

import com.guithub.database.service.DAOService;
import com.guithub.database.service.IDAOVersions;
import com.guithub.domain.Project;
import com.guithub.domain.Version;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
@Component
public class DAOVersions extends DAOService implements IDAOVersions {
    @Override
    public Version save(Version obj) {
        return this.daoRepositories.getVersionRepository().saveAndFlush(obj);
    }

    @Override
    public void delete(Version obj) {

    }

    @Override
    public Version getById(long id) {
        return this.daoRepositories.getVersionRepository().findById(id);
    }

    @Override
    public List<Version> getAll() {
        return null;
    }

    @Override
    public Version archive(long Id, boolean archive) {
        return null;
    }

    @Override
    public List<Version> findAllByProject(Project project, boolean approved, boolean archived) {
       // return this.daoRepositories.getVersionRepository().findAllByProjectAndApproveAndArchived(project, approved, archived);
        return null;
    }

    @Override
    public List<Version> findAllByProject(Project project, boolean approved) {
        //return this.daoRepositories.getVersionRepository().findAllByProjectAndApproveAndArchived(project,approved,false);
        return null;
    }

    @Override
    public List<Version> findAllByProject(Project project) {
       // return this.daoRepositories.getVersionRepository().findAllByProjectAndArchived(project, false);
        return null;
    }
}
