package hello.hellospring.controller;

@Controller
public class HelloController {

	 @GetMapping("hello") public String hello(Model model) {
	 model.addAttribute(attributeName:"data",attributeValue:"hello!");
	 return "hello";
	 }
	
	// MVC
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute(attributeName:"name",name);
		return "hello-template";
	}
	
	// API
	@GetMapping("hello-string")
	@ResponseBody // http에서 header/body 중 body부에 아래 return 데이터를 '직접' 넣어주겠다는 의미.
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	 
	static class Hello {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
