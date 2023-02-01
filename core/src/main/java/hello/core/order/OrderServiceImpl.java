package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    //구현체에 의존하지 않고 인터페이스에만 의존함, final은 값을 무조건 할당해야 하기 때문에 지움
    //할인 정책을 변경하려면 클라이언트인 orderServiceImpl 코드를 고쳐야 했다.
    //OrderServiceImpl은 DiscountPolicy 인터페이스뿐만 아니라 구현체에도 의존하고 있었다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
