package selftech.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 초기화 소멸 빈 스코프
 * 1. InitializingBean, DisposableBean -> 이름이나 코드 변경 못함(스프링 전용 인터페이스)
 *
 */
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect: " + url);
    }

    //서비스 시작 시 호출
    public void call(String message) {
        System.out.println("message = " + message);
        System.out.println("call = " + url);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    //초기화 메서드
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메서드");
    }

    //소멸시 메서드
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }

//    //DisposableBean 소멸 메서드 지원
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
//
//    //InitializingBean 초기화 메서드 지원
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
}
