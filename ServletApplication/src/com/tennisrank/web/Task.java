package com.tennisrank.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {
    String run(HttpServletRequest request, HttpServletResponse response);
}
