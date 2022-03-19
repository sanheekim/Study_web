package hello.hellospring.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import hello.hellospring.domain.Member;

public class JpaMemberRepository implements MemberRepository{

	private final EntityManager em;
	
	public JpaMemberRepository(EntityManager em) {
		rhis.em = em;
	}
	
	@Override
	public Member save(Member member) {
		em.persist(member);
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		Member member = em.find(Member.class,id);
		return Optional.ofNullable(member);
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = em.createQuery(qlString:"select m from Member m where m.name = :name", Member.class)
				.setParameter(name:"name",name)
				.getResultList();
		return result.stream().findAny();
	}
	
	@Override
	public List<Member> findAll(){
		List<Member> result = em.createQuery(qlString:"select m from Member m", Member.class)
					.getResultList();
		return result;
	}
	
}
