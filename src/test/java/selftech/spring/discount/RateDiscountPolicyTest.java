package selftech.spring.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip() {
        //given
        Member member = new Member(1L, "memberVip", Gradle.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    void generate() {
        //given
        Member member = new Member(2L, "memberGen", Gradle.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}