package com.guithub.helpers.ajax;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nick on 18.07.17.
 */
public abstract class APIResponse {
    protected HttpServletResponse response;

    public APIResponse(HttpServletResponse response) {
        this.response = response;
    }

    public APIResponse(HttpServletResponse response, int code) {
        this.response = response;
        this.response.setStatus(code);
    }
}
