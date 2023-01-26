package selftech.spring.web.frontcontroller.v5;

import selftech.spring.web.frontcontroller.ModelView;
import selftech.spring.web.frontcontroller.MyView;
import selftech.spring.web.frontcontroller.v3.controller.MemberFormControllerV3;
import selftech.spring.web.frontcontroller.v3.controller.MemberListControllerV3;
import selftech.spring.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import selftech.spring.web.frontcontroller.v4.controller.MemberFormControllerV4;
import selftech.spring.web.frontcontroller.v4.controller.MemberListControllerV4;
import selftech.spring.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import selftech.spring.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import selftech.spring.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    //모든 컨트롤러 저장소
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    //모든 어뎁터 저장소
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        //V3 버전
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //V5 버전
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }
    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //컨트롤러 찾기
        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //어뎁터 찾기
        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        //컨트롤러 실행
        ModelView mv = adapter.handle(request, response, handler);
        //전체 경로 만들기
        MyView view = viewResolver(mv.getViewName());
        //dispatcher
        view.render(mv.getModel(), request, response);


    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }


    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)) return adapter;
        }
        throw new IllegalArgumentException("handler에 대한 adapter ㄴㄴㄴ");
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }
}
