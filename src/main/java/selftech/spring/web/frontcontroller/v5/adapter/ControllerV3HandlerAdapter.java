package selftech.spring.web.frontcontroller.v5.adapter;

import selftech.spring.web.frontcontroller.ModelView;
import selftech.spring.web.frontcontroller.v3.ControllerV3;
import selftech.spring.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //위에 supports 에서 ControllerV3인지 체크 했기 때문에 추가적인 검사는 없습니다.
        ControllerV3 controller = (ControllerV3) handler;
        //이부분은 프론트 컨트롤러에서 했던 부분입니다. 이제는 어뎁터가 컨트롤러를 호출합니다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);
        return mv;
    }


    private Map<String,String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
