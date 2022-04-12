package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {
	
	/*
	 * private DataSource dataSource;
	 * 
	 * @Autowired public SpringConfig(DataSource dataSource) { this.dataSource =
	 * dataSource; }
	 */
	
	/*
	 * private EntityManager em;
	 * 
	 * @Autowired public SpringConfig(EntityManager em) { this.em = em; }
	 */

	private final MemberRepository memberRepository;
	@Autowired
	public SpringConfig(MemberRepository memberRepository)
	{
		this.memberRepository = memberRepository;
	}
	
	/*
	 * @Bean public MemberService memberService() { return new
	 * MemberService(memberRepository()); }
	 */
	
	/*
	 * @Bean public TimeTraceAop TimeTraceAop() { return new TimeTraceAop(); }
	 */
	
	/*
	 * @Bean public MemberRepository memberRepository() { //return new
	 * MemoryMemberRepository(); //return new JdbcMemberRepository(dataSource);
	 * //return new JdbcTemplateMemberRepository(dataSource); return new
	 * JpaMemberRepository(); }
	 */
}
