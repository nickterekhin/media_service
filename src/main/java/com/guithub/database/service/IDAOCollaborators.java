package com.guithub.database.service;

import com.guithub.domain.Collaborator;
import com.guithub.domain.Project;
import com.guithub.domain.User;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOCollaborators extends IDAOService<Collaborator> {
    List<Collaborator> findByUserAndRole(User user, int role);

    List<Collaborator> findByProject(Project project);
}
