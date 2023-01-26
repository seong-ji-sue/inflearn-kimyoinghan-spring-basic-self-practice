package selftech.spring.web.frontcontroller.v5;

import selftech.spring.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(Object handler);// handler 는 컨트롤러, 어뎁터가 컨트롤러 처리 가능 여부
    //컨트롤러 호출 ModelView 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
