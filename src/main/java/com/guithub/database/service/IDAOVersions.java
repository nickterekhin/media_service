package com.guithub.database.service;

import com.guithub.domain.Project;
import com.guithub.domain.Version;

import java.util.List;

/**
 * Created by Nick on 20.05.17.
 */
public interface IDAOVersions extends IDAOService<Version> {
    List<Version> findAllByProject(Project project, boolean approved, boolean archived);
    List<Version> findAllByProject(Project project, boolean approved);
    List<Version> findAllByProject(Project project);

}
