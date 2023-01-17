package selftech.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;
import selftech.spring.member.MemberServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		MemberServiceImpl memberService = new MemberServiceImpl();
		Member member = new Member(1L, "memberA", Gradle.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("findMember.getName() = " + findMember.getName());
		System.out.println("member.getName() = " + member.getName());

		SpringApplication.run(Application.class, args);
	}

}
