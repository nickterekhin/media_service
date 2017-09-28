package com.guithub.database.repository;

import com.guithub.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findProjectByIdAndActive(long id, boolean active);

  /*  Project findProjectByProjectNameAndUserAndArchived(String projectName, User user, boolean archoved);*/

}
