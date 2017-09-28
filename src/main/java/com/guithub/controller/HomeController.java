package com.guithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 20.05.17.
 */
@Controller
public class HomeController extends BaseController {


    @RequestMapping(value = {"index","","/"},method = {RequestMethod.GET,RequestMethod.POST})
    @Override
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp,ModelAndView model) {
        this.model = model;

        this.model.setViewName("home");
        if(request.getMethod().equals("POST"))
        {
            this.SignUpAction(request);
        }
        return this.model;
    }
}
