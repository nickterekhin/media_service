package com.guithub.filters;

import com.guithub.services.AuthenticationService;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nick on 27.05.17.
 */
@Component
public class AuthenticationFilter implements Filter {


    private AuthenticationService authenticationService;

    public AuthenticationFilter(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //authenticationService = new AuthenticationService();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        if(authenticationService.check(httpReq,httpRes))
        {
            chain.doFilter(httpReq,httpRes);

        }else
        {
            if(httpReq.getAttribute("redirect")!=null) {
                httpRes.sendRedirect((String) httpReq.getAttribute("redirect"));
            }else {
                httpRes.sendRedirect("login");
            }
        }

        //chain.doFilter(httpReq,httpRes);
    }

    @Override
    public void destroy() {

    }
}
