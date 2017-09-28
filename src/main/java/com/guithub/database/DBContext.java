package com.guithub.database;

import com.guithub.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Nick on 20.05.17.
 */
@Service
@Scope
public class DBContext {
    @Autowired
    private IDAOUsers daoUsers;

    @Autowired
    private IDAOVersions daoVersions;

    @Autowired
    private IDAOProject daoProject;

    @Autowired
    private IDAOCollaborators daoCollaborators;

    @Autowired
    private IDAOUserGroups daoUserGroups;

    public IDAOUsers getDaoUsers() {
        return daoUsers;
    }

    public IDAOVersions getDaoVersions() {
        return daoVersions;
    }

    public IDAOProject getDaoProject() {
        return daoProject;
    }

    public IDAOCollaborators getDaoCollaborators() {
        return daoCollaborators;
    }

    public IDAOUserGroups getDaoUserGroups() {
        return daoUserGroups;
    }
}
