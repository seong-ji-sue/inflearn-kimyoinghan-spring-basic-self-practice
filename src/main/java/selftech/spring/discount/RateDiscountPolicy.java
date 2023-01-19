package selftech.spring.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;


/**
 * 할인정책
 */
@Component
@Qualifier("rateDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPolicy = 10;

    //Vip이면 10프로 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGradle() == Gradle.VIP) return price * discountPolicy/100;
        else return 0;
    }
}
