package com.flab.d0_server.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test/annotation")
public class AnnotationServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet Init");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet Service");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Annotation Servlet!~</h1><body></html>");
    }
}
