package hello.hellospring.controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService = new MemberService();

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
}
