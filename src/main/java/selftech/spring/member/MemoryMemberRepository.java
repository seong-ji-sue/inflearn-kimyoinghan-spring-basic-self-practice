package selftech.spring.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 회원 저장소 기능 구현체
 */
@Component
public class MemoryMemberRepository implements MemberRepository{

    //회원 저장소
    private static Map<Long, Member> store = new HashMap<>();

    //회원정보 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //회원 찾기
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
