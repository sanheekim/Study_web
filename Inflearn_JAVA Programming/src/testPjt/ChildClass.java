package testPjt;

public class ChildClass {
	
	public String name;
	public String gender;
	public int age;
	
	public ChildClass() {
		System.out.println("-- ChildClass constructor --");
	}
	
	public void getInfo() {
		System.out.println("-- getInfo() START --");
		System.out.println("name : "+name);
		System.out.println("gender : "+gender);
		System.out.println("age : "+age);
	}
	
	public void setInfo(String n, String g, int a) {
		System.out.println("-- setInfo() START --");
		name = n;
		gender = g;
		age = a;
	}

}
