package lec02Pjt001;

public class OuterClass {
	
	int num = 10;
	String str1 = "java";
	static String str11 = "world";
	public OuterClass() {
		System.out.println("OuterClass constructor");
	}
	
	class InnerClass {
		int num = 100;
		String str2 = str1;
		
		public InnerClass() {
			System.out.println("InnerClass constructor");
		}
	}
	
	static class SInnerClass {
		int num = 1000;
		// static 클래스는 외부 클래스 멤버에 접근 불가능.
		// String str3 = str1;
		String str3 = str11;
		
		public SInnerClass() {
			System.out.println("static InnerClass constructor");
		}
	}

}
