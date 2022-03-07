package hello.hellospring.controller;

@Controller
public class HelloController {

	 @GetMapping("hello") public String hello(Model model) {
	 model.addAttribute(attributeName:"data",attributeValue:"hello!");
	 return "hello"; }
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute(attributeName:"name",name);
		return "hello-template";
	}
	
}
