package hello.core.autowired;

import hello.core.member.Member;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); //<- componentScan 하는 것처럼 spring bean 으로 등록 됨
    }


    static class TestBean{
        //호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            //Member은 스프링 컨테이너에서 관리하지 않음, 스프링 빈이 없다는 걸 보여주기 위함
        }

        //null
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = "+member);
        }

        //Optional.empty
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = "+member);
        }
    }
}
