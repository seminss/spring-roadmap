package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
/*        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService();*/

        //AppConfig 에 있는 환경 설정 정보를 모두 스프링 빈에 등록을 해준다.(@Bean이 붙은)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 컨테이너에서 Bean 정보를 꺼낼 때는 이름, 타입을 주고 꺼내면 된다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 이름(기본: 메서드명), 반환 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
