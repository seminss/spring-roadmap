package hello.core.singleton;

import com.sun.source.tree.AssertTree;
import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configuration(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

/*        //모두 같은 인스턴스를 참고하고 있다. , 테스트용 코드 지워서 실행 안됨
        System.out.println("memberService -> memberRepository = "+ memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = "+ orderService.getMemberRepository());
        System.out.println("memberRepository = "+memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);*/
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class); //AppConfig도 스프링 빈으로 등록된다.

        System.out.println("bean = "+bean.getClass()); //클래스 타입이 뭔지 확인
    }
}