package selftech.spring.domain.member;

import lombok.Getter;
import lombok.Setter;

/**
 * Servlet - 회원 담을 객체
 */
@Getter @Setter
public class Member {
    private Long id;
    private String username;
    private int age;

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
