package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        //ThreadA : A 사용자 10000원 주문
        StatefulService statefulService1 = ac.getBean("statefulService",StatefulService.class);
        //ThreadB : B 사용자 20000원 주문
        StatefulService statefulService2 = ac.getBean("statefulService",StatefulService.class);

        //ThreadA : 사용자 A 주문 금액 조회
        int userAPrice=statefulService1.order("userA",10000);
        //ThreadA : 사용자는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        int userBPrice=statefulService2.order("userB",20000);

        //다르게 나옴
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

/*        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);*/
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
