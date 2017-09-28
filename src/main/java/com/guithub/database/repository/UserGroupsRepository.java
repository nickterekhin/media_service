package com.guithub.database.repository;

import com.guithub.domain.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nick on 20.05.17.
 */
public interface UserGroupsRepository extends JpaRepository<UserGroup, Long> {
    UserGroup saveAndFlush(UserGroup userGroup);
    UserGroup findByGroupNameAndActiveTrue(String groupName);
}
