package com.guithub.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 28.05.17.
 */
@Controller
public class ProfileController extends BaseProfileController{

    @Override
    @RequestMapping(value={"/{a:.+}",""},method = {RequestMethod.POST,RequestMethod.GET})
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp, ModelAndView model) {
        request.getParameter("a");

        model.setViewName("/profile/show");
        return model;
    }

}
