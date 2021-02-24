package lifecoding.java1.basic;

public class StringApp {
	
	public static void main(String[] args) {
		
		// java에서는 ""와 ''를 구분해서 사용함.
		System.out.println("Hello World"); // String, 문자열
		// System.out.println('Hello World'); // error. java에서는 ''를 특수한 데이터타입(Character, 문자 1개)으로 표시함
		System.out.println('H'); // Character, 문자 1개
		System.out.println("H"); // String, 한 글자지만 문자열
		
		System.out.println("Hello "
				+ "World"); // 줄바꿈 안 됨.
		System.out.println("Hello \nWorld"); // \n은 new line이라는 뜻으로 줄바꿈 됨.
		
		// java에서 ""는 문자의 시작과 끝을 알림.
		// \"는 escape라는 뜻.
		System.out.println("Hello \"World\""); // Hello "World"
		
		System.out.println("Hello World".length()); // 11. 띄어쓰기를 포함한 글자수를 셈.
		System.out.println("Hello, leezche ... bye. ".replace("leezche", "sanhee")); // leezche를 sanhee로 바꿈.
		
	}

}
