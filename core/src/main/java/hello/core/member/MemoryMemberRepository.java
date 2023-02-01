package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    //동시성 이슈가 있을 수 있기 때문에 Concurrent HashMap을 써야 한다.(실무에선)
    //현재는 공부용으로 단순하게 개발 중이기 때문에 그냥 저장소로 HashMap 선언!
    public static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
