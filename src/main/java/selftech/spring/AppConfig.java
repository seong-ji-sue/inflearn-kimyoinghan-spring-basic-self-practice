package selftech.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import selftech.spring.discount.DiscountPolicy;
import selftech.spring.discount.RateDiscountPolicy;
import selftech.spring.member.MemberService;
import selftech.spring.member.MemberServiceImpl;
import selftech.spring.member.MemoryMemberRepository;
import selftech.spring.order.OrderService;
import selftech.spring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
