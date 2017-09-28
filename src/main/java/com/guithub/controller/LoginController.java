package com.guithub.controller;

import com.guithub.domain.User;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController extends BaseController{

    @RequestMapping(value = {"login", "logout"},method = {RequestMethod.GET,RequestMethod.POST})
    @Override
    protected ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp, ModelAndView model) {

        HttpSession session = request.getSession(true);

        if (request.getServletPath().equals("/logout")) {
            this.logout(request,resp);
            return null;
        }

        if(request.getMethod().equals("POST"))
        {
            String username = request.getParameter("userName");
            String password = request.getParameter("password");

            User u = dbContext.getDaoUsers().checkUserNameAndPassword(username,password,true);

            try {
                if (u != null) {

                    this.authenticationService.initUserSession(session,u);

                    Cookie uid = new Cookie("m3627738_uid", u.getUsername());
                    Cookie pass = new Cookie("m3627738_pwd", u.getPassword());
                    uid.setMaxAge((int) (DateTime.now().getMillis() / 1000) + (365 * 24 * 3600));
                    pass.setMaxAge((int) (DateTime.now().getMillis() / 1000) + (365 * 24 * 3600));
                    resp.addCookie(uid);
                    resp.addCookie(pass);
                    resp.sendRedirect("/profile");
                } else {
                    this.notifications.show(model, "Incorrect Login or/and password", "alert-danger");
                }
            }catch (Exception e)
            {
                this.notifications.show(model,e.getMessage(),"alert-danger");
            }
        }

        model.setViewName("pages/login");

        return model;
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie userCookie =null;
        Cookie passwdCookie =null;
        Cookie[] cookies = request.getCookies();
        HttpSession session  = request.getSession(false);

        if(session!=null && session.getAttribute("user")!=null && (Boolean)session.getAttribute("isLogin")) {
            session.invalidate();
        }
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("m3627738_uid"))
                    userCookie = cookie;
                if(cookie.getName().equals("m3627738_pwd"))
                    passwdCookie = cookie;

            }
            if (userCookie!=null && passwdCookie!=null) {

                userCookie.setMaxAge(0);
                passwdCookie.setMaxAge(0);
                response.addCookie(userCookie);
                response.addCookie(passwdCookie);

            }
        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
