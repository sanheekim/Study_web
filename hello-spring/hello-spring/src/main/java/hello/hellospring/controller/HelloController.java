package hello.hellospring.controller;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute(attributeName:"data",attributeValue:"hello!");
		return "hello";
	}
}
