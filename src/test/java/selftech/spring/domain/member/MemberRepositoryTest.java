package selftech.spring.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * servlet- 회원 Repository 테스트
 */
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance(); //싱글톤

    //테스트 종료마다 초기화
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);


        //when
        Member saveMember = memberRepository.save(member);

        //then
        Assertions.assertThat(member).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member = new Member("hello", 20);
        Member member1 = new Member("hello1", 22);
        Member saveMember = memberRepository.save(member);
        Member saveMember1 = memberRepository.save(member1);


        //when
        List<Member> members = memberRepository.findAll();

        //then
        Assertions.assertThat(members.size()).isEqualTo(2);
    }
}