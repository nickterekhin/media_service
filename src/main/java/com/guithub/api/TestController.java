package com.guithub.api;

import com.guithub.helpers.ajax.APIStatusCodes;
import com.guithub.helpers.ajax.APIResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 18.06.17.
 */
@Controller
public class TestController {

    @RequestMapping(value={"api/testT"}, method= RequestMethod.GET)
    public @ResponseBody
    APIResponseObject indexT(HttpServletResponse response)
    {


        return APIResponseObject.build(response,"Hello world", APIStatusCodes.SUCCESS,"");
    }
}
