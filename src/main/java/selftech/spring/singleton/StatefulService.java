package selftech.spring.singleton;

/**
 * 자바코드로 싱글톤을 구현한것 중 상태로 설계한것
 */
public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
