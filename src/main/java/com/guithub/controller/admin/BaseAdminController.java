package com.guithub.controller.admin;

import com.guithub.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Nick on 28.05.17.
 */
@Controller
@RequestMapping(value="/admin",method = {RequestMethod.GET,RequestMethod.POST})
public abstract class BaseAdminController extends BaseController{

}
