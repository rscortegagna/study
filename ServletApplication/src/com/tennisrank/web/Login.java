package com.tennisrank.web;

import com.tennisrank.User;
import com.tennisrank.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new UserDAO().findByEmailAndPassword(email, password);

        PrintWriter writer = resp.getWriter();

        if (user == null) {
            writer.println("<html><body> Invalid User </html></body>");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);

            writer.println("<html><body>User " + email + " logged in successfully.</html></body>");
        }
    }
}
