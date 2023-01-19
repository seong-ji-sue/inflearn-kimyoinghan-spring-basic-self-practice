package selftech.spring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selftech.spring.AppConfig;
import selftech.spring.member.MemberService;

/**
 * AppConfig로 구현 시 문제점
 */
public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        MemberService memberService1 = appConfig.memberService();
        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);
        //참조값 다름
        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }
}
