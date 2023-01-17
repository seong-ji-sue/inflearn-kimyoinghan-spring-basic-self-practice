package selftech.spring.befind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import selftech.spring.member.MemberRepository;
import selftech.spring.member.MemberServiceImpl;
import selftech.spring.member.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("같은 타입 둘이상")
    void findBeanByTypeDuplicate() {
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        Assertions.assertThat(memberRepository).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("특정 타입 모두 조회")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key);
            System.out.println("key = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
