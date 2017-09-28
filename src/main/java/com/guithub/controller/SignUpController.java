package com.guithub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 21.05.17.
 */
@Controller
public class SignUpController extends BaseController {


    @RequestMapping(value="/signup", method = {RequestMethod.POST,RequestMethod.GET})
    @Override
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp, ModelAndView model) {
        this.model = model;
        this.model.setViewName("signup");
        if(request.getMethod().equals("POST"))
        {
            this.SignUpAction(request);
        }
        return this.model;
    }
}
