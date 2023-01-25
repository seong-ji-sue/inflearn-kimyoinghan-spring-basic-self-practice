package selftech.spring.web.frontcontroller.v3;

import selftech.spring.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
