package com.guithub.controller.profile;

import com.guithub.domain.Project;
import com.guithub.helpers.ActionsList;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Nick on 04.07.17.
 */
@Controller
public class ProjectController extends BaseProfileController {
    private String projectFolder;
    @Override
    @RequestMapping(value={"/projects/{a:.+}","/projects"},method = {RequestMethod.POST,RequestMethod.GET})
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp, ModelAndView model) {
         this.actionsList = ActionsList.getType(request.getParameter("a"));

        switch(actionsList)
        {
            case LIST:
                List<Project> projects = this.dbContext.getDaoProject().getAll();
                model.addObject("projects",projects);
                model.setViewName("/profile/project/list");
                break;
            case ADD:
                if(request.getParameter("save-action")!=null && request.getParameter("save-action").equals("1"))
                {
                    HttpSession session = request.getSession(false);

                    Project project = new Project();
                    project.setName(request.getParameter("project-name"));
                    project.setSlug(this.formatSlug(request.getParameter("project-name")));
                    project.setActive(Boolean.valueOf(request.getParameter("active")));
                    project.setCreatedAt(new DateTime());
                    project.setOwnerId(authenticationService.getUser().getId());

                    project = this.dbContext.getDaoProject().save(project);
                    this.createProjectEnv(project);
                    model.setViewName("redirect:/profile/projects");
                }
                else {

                    model.setViewName("/profile/project/add");
                }
                break;
            case EDIT:
                break;
            case DELETE:
                break;
            case STATUS:
                break;

        }

            return model;

    }

    private boolean createProjectEnv(Project project)
    {
        File file = new File(String.format("%s%s%s%s%s","users",File.separator,project.getOwnerId(),File.separator,
                project.getSlug()));
        boolean mkdir = false;
        if(!file.exists()) {
             mkdir = file.mkdirs();
        }

        if(mkdir)
        {
            boolean mainDir = false;
            boolean collaboratorsDir = false;
            String path = file.getPath();
            File main = new File(String.format("%s%s%s",file.getPath(),File.separator,"main.git"));
                if(!main.exists())
                {
                    mainDir = main.mkdir();
                }
            File collaborators = new File(String.format("%s%s%s",file.getPath(),File.separator,"collaborators"));
                if(!collaborators.exists())
                {
                    collaboratorsDir = collaborators.mkdir();
                }
            if(collaboratorsDir)
            {
                File admin_collaborators = new File(String.format("%s%s%s",collaborators.getPath(),File.separator,
                        project.getOwnerId()));
                if(!admin_collaborators.exists())
                {
                    admin_collaborators.mkdir();
                }
            }
        }

        return true;

    }
}
