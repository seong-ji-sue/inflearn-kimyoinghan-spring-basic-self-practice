package selftech.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import selftech.spring.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 상태를 공유하기 때문에 다른 요청이 들어와도 같은 객체를 수정하게 된다.
 */
class StatefulServiceTest {

    @Test
    @DisplayName("상태로 싱글톤 설계 테스트")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("userA", 1000);
        statefulService1.order("userB", 2000);

        int price = statefulService1.getPrice();

        System.out.println("price = " + price);// 2000

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}