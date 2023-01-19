package selftech.spring.member;

/**
 * 회원 저장소 기능
 */
public interface MemberRepository {
    //회원 저장
    void save(Member member);
    //회원 찾기
    Member findById(Long memberId);
}
