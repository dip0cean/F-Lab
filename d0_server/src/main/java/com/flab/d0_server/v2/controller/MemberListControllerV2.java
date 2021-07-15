package com.flab.d0_server.v2.controller;

import com.flab.d0_server.v2.view.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberListControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This Page is Member List Page V2");
        return new MyView("list");
    }
}
