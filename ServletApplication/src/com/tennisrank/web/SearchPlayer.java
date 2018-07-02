package com.tennisrank.web;

import com.tennisrank.Player;
import com.tennisrank.dao.PlayersDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@WebServlet(urlPatterns = "/search")
public class SearchPlayer implements Task {

    @Override
    public String run(HttpServletRequest request, HttpServletResponse response) {
        String filter = request.getParameter("filter");
        Collection<Player> players = new PlayersDAO().searchBySimilarity(filter);

        request.setAttribute("players", players);
        return "/WEB-INF/pages/searchPlayer.jsp";
    }
}
