package com.flab.d0_server.v1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV1 extends HttpServlet implements ControllerV1 {
    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This Page is Member Save Page");
        String            viewPath   = prefix + "save" + suffix;
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
