package com.tennisrank.web;

import com.tennisrank.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class WebInterceptor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //do nothing for now
    }

    @Override
    public void destroy() {
        //do nothing for now
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String user = "<notLoggedIn>";

        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser != null) {
            user = loggedUser.getEmail();
        }

        System.out.println("User " + user + " accessing URI: " + request.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
