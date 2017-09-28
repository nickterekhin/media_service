package com.guithub.services.git_api;

import com.guithub.domain.Project;

/**
 * Created by Nick on 05.07.17.
 */
public interface IGITService {

    boolean initEnvironment(Project project);
    boolean initRepository();
    boolean deploy();
    boolean pull();
    boolean push();
    boolean commit();
    void showGit(Project project,String path);
    void showDiff(String hashGit,Project project);

}
