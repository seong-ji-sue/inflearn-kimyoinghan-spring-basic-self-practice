package selftech.spring.web.frontcontroller.v3;

import selftech.spring.web.frontcontroller.ModelView;
import selftech.spring.web.frontcontroller.MyView;
import selftech.spring.web.frontcontroller.v2.controller.MemberFormControllerV2;
import selftech.spring.web.frontcontroller.v2.controller.MemberListControllerV2;
import selftech.spring.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import selftech.spring.web.frontcontroller.v3.controller.MemberFormControllerV3;
import selftech.spring.web.frontcontroller.v3.controller.MemberListControllerV3;
import selftech.spring.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);

        if(controller ==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        Map<String, String> paramMap = createParamMap(request);//파라미터 받은거 paramMap에 담기
        ModelView mv = controller.process(paramMap);// 컨트롤러 실행
        String viewName = mv.getViewName();//JSP 파일 이름 꺼내기
        MyView view = viewResolver(viewName);//전체 경로 만들기
        view.render(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String,String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
