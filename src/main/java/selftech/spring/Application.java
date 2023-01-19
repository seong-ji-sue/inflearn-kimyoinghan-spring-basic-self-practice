package selftech.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import selftech.spring.member.Gradle;
import selftech.spring.member.Member;
import selftech.spring.member.MemberService;
import selftech.spring.member.MemberServiceImpl;


@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
