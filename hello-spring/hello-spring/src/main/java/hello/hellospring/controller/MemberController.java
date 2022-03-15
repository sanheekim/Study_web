package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;

	/* setter 주입
	 * @Autowired public void setMemberService(MemberService memberService) {
	 * this.memberService = memberService; }
	 */
	

	 @Autowired
	 public MemberController(MemberService memberService) {
		 this.memberService = memberService;
		 }
	 
	
	
}
