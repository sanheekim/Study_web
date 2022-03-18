package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행함.
@Transactional // 테스트 케이스에 이 에노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. (테스트 하나마다 적용됨.) 이러면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않음.
public class MemberServiceIntegrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	public void 회원가입() throws Exception {
		
		// given
		Member member = new Member();
		member.setName("hello");
		
		// when
		Long saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	
}
