package selftech.spring.singleton;

/**
 * 자바코드로 싱글톤을 구현했을 때
 */
public class SingletonService {

    // 인스턴스 하나만 생성하도록
    private static final SingletonService instance = new SingletonService();

    //인스턴스를 공유하기 위해 사용하려면 이 메서드를 호출해야 합니다.
    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private로 선언해서 외부에서 new 키워드로 접근 못하게 한다.
    //생성자를 작성 안하면 public이 기본값이어서 적었다.
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
