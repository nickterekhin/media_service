package com.guithub.database.service.impl;

import com.guithub.database.service.DAOService;
import com.guithub.database.service.IDAOUserGroups;
import com.guithub.domain.UserGroup;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
@Component
public class DAOUserGroups extends DAOService implements IDAOUserGroups {
    @Override
    public UserGroup save(UserGroup obj) {
        return this.daoRepositories.getUserGroupsRepository().saveAndFlush(obj);
    }

    @Override
    public void delete(UserGroup obj) {

    }

    @Override
    public UserGroup getById(long id) {
        return null;
    }

    @Override
    public List<UserGroup> getAll() {
        return null;
    }

    @Override
    public UserGroup archive(long Id, boolean archive) {
        return null;
    }

    @Override
    public UserGroup getByGroupName(String groupName) {
        return this.daoRepositories.getUserGroupsRepository().findByGroupNameAndActiveTrue(groupName);
    }
}
