package com.guithub.controller;

import com.guithub.database.DBContext;
import com.guithub.domain.User;
import com.guithub.domain.UserGroup;
import com.guithub.services.AuthenticationService;
import com.guithub.services.Notifications;
import com.guithub.domain.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 20.05.17.
 */
@Controller
public abstract class BaseController  {

    protected ModelAndView model;
    @Autowired
    protected DBContext dbContext;
    @Autowired
    protected Notifications notifications;

    @Autowired
    @Qualifier("authenticationService")
    protected AuthenticationService authenticationService;

    protected abstract ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse resp, ModelAndView model);

    @PostConstruct
    private void initAdmin()
    {
        User admin = dbContext.getDaoUsers().getById(1L);
        if(admin==null) {
            UserGroup userGroupAll = new UserGroup(Permissions.All.getGroupName(), Permissions.All, true);
            userGroupAll = dbContext.getDaoUserGroups().save(userGroupAll);

            UserGroup userGroup = new UserGroup(Permissions.ADMIN.getGroupName(), Permissions.ADMIN, true);
            dbContext.getDaoUserGroups().save(userGroup);

            UserGroup userGroupGuest = new UserGroup(Permissions.GUEST.getGroupName(), Permissions.GUEST, true);
            dbContext.getDaoUserGroups().save(userGroupGuest);

            UserGroup userGroupCollaborator = new UserGroup(Permissions.COLLABORATORS.getGroupName(), Permissions.COLLABORATORS, true);
            dbContext.getDaoUserGroups().save(userGroupCollaborator);

            User u = new User(userGroupAll.getId(), "NickTer", "456258", "nick.terekhin@gmail.com", true);
            dbContext.getDaoUsers().save(u);
        }
    }

    protected void SignUpAction(HttpServletRequest request)
    {

        if(request.getParameter("signup-form")!=null && request.getParameter("signup-form").equals("1") )
        {
            UserGroup uGroup =  dbContext.getDaoUserGroups().getByGroupName(Permissions.COLLABORATORS.getGroupName());

            User user = new User(uGroup.getId(),request.getParameter("userName"),request.getParameter("password"),request.getParameter("email"),true);
            this.model.addObject("isSignUp", false);

            if(!ValidateUser(user)) {
                this.notifications.show(this.model, "All fields must be field", "alert-danger");
            }else {

                try{
                    if (dbContext.getDaoUsers().checkUserInfo(user.getUsername(), user.getEmail())) {
                        dbContext.getDaoUsers().save(user);
                        this.notifications.show(this.model, "We glad to see you with us.", "alert-success");
                        this.model.addObject("isSignUp", true);

                    }
                }catch(Exception e)
                {
                    this.notifications.show(this.model, e.getMessage(), "alert-danger");
                }
            }
        }

    }

    private boolean ValidateUser(User user)
    {
        return !(user.getEmail().isEmpty()
                || user.getUsername().isEmpty()
                || user.getPassword().isEmpty()
        );
    }

}
