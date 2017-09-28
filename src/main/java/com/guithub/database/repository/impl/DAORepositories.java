package com.guithub.database.repository.impl;

import com.guithub.database.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nick on 20.05.17.
 */
@Service
public class DAORepositories {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserGroupsRepository userGroupsRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public VersionRepository getVersionRepository() {
        return versionRepository;
    }

    public CollaboratorRepository getCollaboratorRepository() {
        return collaboratorRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public UserGroupsRepository getUserGroupsRepository() {
        return userGroupsRepository;
    }
}
