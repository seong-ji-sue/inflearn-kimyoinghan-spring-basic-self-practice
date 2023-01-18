package selftech.spring.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import selftech.spring.discount.DiscountPolicy;
import selftech.spring.discount.FixDiscountPolicy;
import selftech.spring.discount.RateDiscountPolicy;
import selftech.spring.member.Member;
import selftech.spring.member.MemberRepository;
import selftech.spring.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    //의존하고있고 바뀔때마다 계속 바꿔줘야함
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //회원 ID 아이템이름 아이템가격 할인금액
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
