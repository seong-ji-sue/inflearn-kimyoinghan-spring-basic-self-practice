package selftech.spring;

import selftech.spring.member.Gradle;
import selftech.spring.member.Member;
import selftech.spring.member.MemberServiceImpl;
import selftech.spring.order.Order;
import selftech.spring.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        //회원 ID 생성
        long memberId = 1L;

        //회원 생성
        Member member = new Member(memberId, "memberA", Gradle.VIP);
        memberService.join(member);

        //주문 생성
        Order order = orderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = " + order);
    }
}
