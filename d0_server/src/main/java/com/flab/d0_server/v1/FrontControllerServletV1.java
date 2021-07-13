package com.flab.d0_server.v1;

import com.flab.d0_server.v1.controller.ControllerV1;
import com.flab.d0_server.v1.controller.MemberFormControllerV1;
import com.flab.d0_server.v1.controller.MemberListControllerV1;
import com.flab.d0_server.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
    @value urlPatterns = /v1/front-controller 의 하위 경로에 있는 URL Path 처리
 */
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/v1/front-controller/*")
public class FrontControllerServletV1 extends HttpServlet {
    // 해당 URL 을 처리하는 Controller 를 매핑 할 HashMap 사용
    private Map<String, ControllerV1> controllerMap = new HashMap<>();
    private String                    webAppPath    = "/d0_server_war";

    public FrontControllerServletV1() {
        controllerMap.put(webAppPath + "/v1/front-controller/member/form", new MemberFormControllerV1());
        controllerMap.put(webAppPath + "/v1/front-controller/member/save", new MemberSaveControllerV1());
        controllerMap.put(webAppPath + "/v1/front-controller/member/list", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String       reqUri     = req.getRequestURI();
        ControllerV1 controller = controllerMap.get(reqUri);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(req, resp);
    }
}
