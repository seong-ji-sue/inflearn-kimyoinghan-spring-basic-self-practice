package selftech.spring.discount;

import org.springframework.stereotype.Component;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;


public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;//1000원 할인

    //VIP면 1000, 그냥이면 0 반환
    @Override
    public int discount(Member member, int price) {
        if(member.getGradle() == Gradle.VIP) return discountFixAmount;
        else return 0;
    }
}
