package selftech.spring.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import selftech.spring.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

//    MemberService memberService = new MemberServiceImpl();
    AppConfig appConfig = new AppConfig();

    @Test
    void join() {
        MemberService memberService = appConfig.memberService();
        //given
        Member member = new Member(1L, "member", Gradle.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}