package selftech.spring.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet- 동시성 문제 생략, 싱글톤으로 생성
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //회원 저장소
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {}

    //회원 저장
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //회원 찾기
    public Member findById(Long id) {
        return store.get(id);
    }

    //회원 전체 조회
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //회원 전체 삭제- 테스트 때문에
    public void clearStore() {
        store.clear();
    }

}
