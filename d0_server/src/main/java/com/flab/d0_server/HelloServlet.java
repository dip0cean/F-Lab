package com.flab.d0_server;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        // Request.getSession()
        /*
            현재 요청과 관련된 세션 객체를 리턴한다.
            만약 세션이 존재하지 않는 경우, 새로운 세션을 생성해서 리턴한다.

            세션 객체가 생성된 경우(새로 만들지 않는 경우)에만 세션을 불러오고 싶을 때는 getSession(false); 메소드 사용
         */
        HttpSession  session = request.getSession();
        List<String> ids     = (List<String>) session.getAttribute("ids"); // 해당 세션에 저장된 ids 객체를 받아 온다.
        getServletContext();
    }

    public void destroy() {
    }
}