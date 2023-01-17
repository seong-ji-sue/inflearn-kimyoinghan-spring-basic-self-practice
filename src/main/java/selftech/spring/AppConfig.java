package selftech.spring;

import selftech.spring.discount.DiscountPolicy;
import selftech.spring.discount.RateDiscountPolicy;
import selftech.spring.member.MemberService;
import selftech.spring.member.MemberServiceImpl;
import selftech.spring.member.MemoryMemberRepository;
import selftech.spring.order.OrderService;
import selftech.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
