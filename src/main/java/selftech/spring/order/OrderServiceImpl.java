package selftech.spring.order;

import selftech.spring.discount.DiscountPolicy;
import selftech.spring.discount.FixDiscountPolicy;
import selftech.spring.member.Member;
import selftech.spring.member.MemberRepository;
import selftech.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //회원 ID 아이템이름 아이템가격 할인금액
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
