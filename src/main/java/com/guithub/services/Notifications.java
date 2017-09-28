package com.guithub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Nick on 21.05.17.
 */
@Service
public class Notifications {

    @Autowired
    private Message m;

    public Message show(String text, String type)
    {
        m.setText(text);
        m.setType(type);
        return m;
    }

    public void show(HttpServletRequest request, String text, String type)
    {
        HttpSession s = request.getSession();
        s.setAttribute("message",show(text,type));
    }

    public void show(ModelAndView model, String text, String type)
    {
        model.addObject("message",show(text,type));
    }

    @Component
    @Scope(scopeName = "prototype")
    private class Message
    {
        private String text;
        private String type;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
