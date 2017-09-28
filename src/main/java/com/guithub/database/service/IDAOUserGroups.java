package com.guithub.database.service;

import com.guithub.domain.UserGroup;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOUserGroups extends IDAOService<UserGroup> {
    UserGroup getByGroupName(String groupName);
}
