package selftech.spring.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Request 파라미터 가져오는 방법
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 시작!!!!");
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String paramName = parameterNames.nextElement();
//            System.out.println("paramName = " + paramName);
//        }
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> {
                            System.out.println("paramName = " + paramName);
                            System.out.println("req.getParameter(paramName) = " + req.getParameter(paramName));
                        }
                );
        System.out.println("전체 파라미터 조회 끝");

        System.out.println("단일 파라미터 조회 시작!!!!");
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        System.out.println("단일 파라미터 조회 끝");

        System.out.println("이름이 같은 복수 파라미터 조회 시작");
        String[] usernames = req.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        resp.getWriter().write("ok");

    }
}
