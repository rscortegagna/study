package com.tennisrank.web;

import com.tennisrank.Player;
import com.tennisrank.dao.PlayersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/addPlayer")
public class NewPlayer implements Task {
    @Override
    public String run(HttpServletRequest request, HttpServletResponse response) {
        String playerName = request.getParameter("playerName");
        Player newPlayer = new Player(playerName);
        new PlayersDAO().add(newPlayer);

        request.setAttribute("player", newPlayer);
        return "/WEB-INF/pages/newPlayer.jsp";
    }
}
