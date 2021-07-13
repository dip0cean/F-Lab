package com.flab.d0_server.v1.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
