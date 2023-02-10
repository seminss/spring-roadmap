package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {
    //순수 자바 테스트
    @Test
    void creatOder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA",10000);

        org.assertj.core.api.Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
   }

}