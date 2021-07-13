package com.flab.d0_server.v1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This Page is Member Form Page");
        String            viewPath   = prefix + "form" + suffix;
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req, resp);
    }
}
