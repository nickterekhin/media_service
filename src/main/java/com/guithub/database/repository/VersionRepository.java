package com.guithub.database.repository;

import com.guithub.domain.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {

   /* List<Version> findAllByProjectAndArchived(Project project, boolean archived);*/

    /*List<Version> findAllByProjectAndApproveAndArchived(Project project, boolean approve, boolean archived);*/

    Version saveAndFlush(Version version);

    Version findById(Long id);
}
