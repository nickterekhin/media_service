package com.guithub.controller.profile;

import com.guithub.controller.BaseController;
import com.guithub.helpers.ActionsList;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * Created by Nick on 28.05.17.
 */
@Component
@RequestMapping(value={"/profile"},method = {RequestMethod.GET,RequestMethod.POST})
public abstract class BaseProfileController extends BaseController {
    protected ActionsList actionsList;

    protected String formatSlug(String text)
    {
        if(text==null)
            return "";
        return text.trim().toLowerCase().replaceAll("\\s", "_");
    }

}
