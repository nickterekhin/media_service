package com.guithub.controller.profile;


import com.guithub.domain.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by Nick on 18.08.17.
 */
@Controller
public class FMController extends BaseProfileController {


    @Override
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp,
                                          ModelAndView model) {
        return model;
    }

    @RequestMapping(value={"/project-files/{projectId}/{path}","/project-files/{projectId}"},method = {RequestMethod
            .GET})
    protected ModelAndView requestHandlerFM(@PathVariable Long projectId, @PathVariable String path, ModelAndView model)
    {

        Project project = dbContext.getDaoProject().getById(projectId);
        String projectPath = String.format("%s%s%s",project.getOwnerId(), File.separator,project.getSlug());

        model.setViewName("/profile/fm/show");
        return model;
    }
}
