package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long,Member> store = new HashMap<>();
	private static long sequence = 8L;
	
	@Override
	public Member save(Member member) {
		//return null;
		
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		// return store.get(id);
		return Optional.ofNullable(store.get(id));
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		store.values().stream()
			.filter(member -> member.getName().equals(name))
			.findAny(); // 하나라도 찾는 것
		return Optional.ofNullable(store.get(name));
	}
	
	@Override
	public List<Member> findAll(){
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}
	
	
}
