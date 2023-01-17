package selftech.spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;
import selftech.spring.member.MemberService;
import selftech.spring.member.MemberServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "member", Gradle.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item", 10000);
        Assertions.assertThat(order.getDiscountPolicy()).isEqualTo(1000);

    }
}