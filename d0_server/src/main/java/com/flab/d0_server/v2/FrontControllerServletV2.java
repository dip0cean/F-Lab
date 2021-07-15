package com.flab.d0_server.v2;

import com.flab.d0_server.v2.controller.ControllerV2;
import com.flab.d0_server.v2.controller.MemberFormControllerV2;
import com.flab.d0_server.v2.controller.MemberListControllerV2;
import com.flab.d0_server.v2.controller.MemberSaveControllerV2;
import com.flab.d0_server.v2.view.MyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/v2/front-controller/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();
    private String                    webAppPath    = "/d0_server_war";

    public FrontControllerServletV2() {
        controllerMap.put(webAppPath + "/v2/front-controller/member/form", new MemberFormControllerV2());
        controllerMap.put(webAppPath + "/v2/front-controller/member/save", new MemberSaveControllerV2());
        controllerMap.put(webAppPath + "/v2/front-controller/member/list", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String       requestURI = req.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(req, resp);
        view.render(req, resp);
    }
}
