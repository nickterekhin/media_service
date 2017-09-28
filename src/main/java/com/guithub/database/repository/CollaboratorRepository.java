package com.guithub.database.repository;

import com.guithub.domain.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
  /*  List<Collaborator> findByUserAndRoleAndArchivedFalse(User user, int role);

    List<Collaborator> findByProjectAndArchivedFalse(Project project);*/
}
