package com.guithub.database.service.impl;

import com.guithub.database.service.DAOService;
import com.guithub.database.service.IDAOCollaborators;
import com.guithub.domain.Collaborator;
import com.guithub.domain.Project;
import com.guithub.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */

@Component
public class DAOCollaborators extends DAOService implements IDAOCollaborators {
    @Override
    public List<Collaborator> findByUserAndRole(User user, int role) {
        //return this.daoRepositories.getCollaboratorRepository().findByUserAndRoleAndArchivedFalse(user,role);
        return null;
    }

    @Override
    public List<Collaborator> findByProject(Project project) {
       // return this.daoRepositories.getCollaboratorRepository().findByProjectAndArchivedFalse(project);
        return null;
    }

    @Override
    public Collaborator save(Collaborator obj) {
        return this.daoRepositories.getCollaboratorRepository().saveAndFlush(obj);

    }

    @Override
    public void delete(Collaborator obj) {

    }

    @Override
    public Collaborator getById(long id) {
        return null;
    }

    @Override
    public List<Collaborator> getAll() {
        return null;
    }

    @Override
    public Collaborator archive(long Id, boolean archive) {
        Collaborator c = this.getById(Id);
        //c.setArchived(archive);
        return this.save(c);

    }
}
