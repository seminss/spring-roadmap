package hello.core.member;

//구현체가 하나만 있을 때는 Interface 뒤에 Impl이라고 많이 쓴다.
public class MemberServiceImpl implements MemberService{

    //여기서 인터페이스만 불러오고, 구현 객체를 선택하지 않으면 아래 메서드에서 null point exception 이 터진다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //다형성에 의해 memberRepository 가 아니라 MemoryMemberRepository 에 있는 join 이 호출된다.
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
