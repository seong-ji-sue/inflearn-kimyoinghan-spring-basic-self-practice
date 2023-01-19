package selftech.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;
import selftech.spring.member.MemberService;
import selftech.spring.member.MemberServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "memberA", Gradle.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("findMember.getName() = " + findMember.getName());
		System.out.println("member.getName() = " + member.getName());

		SpringApplication.run(Application.class, args);
	}

}
