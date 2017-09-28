package com.guithub.services;

import com.guithub.database.DBContext;
import com.guithub.domain.Permissions;
import com.guithub.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Nick on 20.05.17.
 */
@Component
@Scope
public class AuthenticationService {

    @Autowired
    private  DBContext dbContext;
    private User user;

    public boolean check(HttpServletRequest request,HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        this.user = this.initUser(request, session);
        if(user==null)
            session.setAttribute("isLogin",false);

        String path = request.getServletPath();
        RestrictionRequest restrictionRequest = RestrictionRequest.getType(request.getServletPath());
        if(restrictionRequest==null)
            return true;

        switch(restrictionRequest)
        {
            case PROFILE:
                return user != null && (user.hasPermission(Permissions.COLLABORATORS) || user.hasPermission(Permissions.ADMIN) || user.hasPermission(Permissions.All));
            case ADMIN:
                return user != null && user.hasPermission(Permissions.ADMIN);
            case LOGIN:
                if(user!=null)
                {
                    request.setAttribute("redirect","profile");
                    return false;

                }
                 break;



        }
        return true;
    }


    public User initUser(HttpServletRequest request, HttpSession session)
    {

            User u = (User) session.getAttribute("user");
            if (u == null) {
                String userName = null;
                String passwd = null;
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("m3627738_uid"))
                            userName = cookie.getValue();
                        if (cookie.getName().equals("m3627738_pwd"))
                            passwd = cookie.getValue();
                    }
                    if (userName != null && passwd != null) {

                        u = dbContext.getDaoUsers().checkUserNameAndPassword(userName, passwd,false);
                        initUserSession(session,u);
                    }
                }
            }
        return u;

    }

    public void initUserSession(HttpSession session, User u)
    {
        session.setAttribute("user", u);
        session.setAttribute("user_id", u.getId());
        session.setAttribute("username", u.getUsername());
        session.setAttribute("userGroup", u.getUserGroup());
        session.setAttribute("permissions", u.getUserGroup().getPermissions());
        session.setAttribute("isLogin", true);
    }

    public User getUser() {
        return user;
    }
}
