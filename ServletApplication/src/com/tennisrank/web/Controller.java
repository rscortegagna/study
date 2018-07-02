package com.tennisrank.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/wtr")
public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String task = req.getParameter("task");

        if (task.isEmpty()) {
            throw new IllegalArgumentException("task cannot be null");
        }

        String className = "com.tennisrank.web." + task;

        try {
            Class type = Class.forName(className);
            Task instance = (Task) type.newInstance();
            String page = instance.run(req, resp);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
