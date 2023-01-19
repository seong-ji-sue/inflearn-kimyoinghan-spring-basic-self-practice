package selftech.spring.discount;

import selftech.spring.member.Member;

/**
 * 할인 정책
 */
public interface DiscountPolicy {
    //가격 할인
    int discount(Member member, int price);


}
