package com.flab.d0_server.v2.controller;

import com.flab.d0_server.v2.view.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
