package lec02Pjt001;

public class MainClass {
	public static void main(String[] args) {
		
		// 내부 클래스
		OuterClass oc = new OuterClass();
		System.out.println("oc.num:"+oc.num);
		System.out.println("oc.str1:"+oc.str1);
		
		// 멤버 inner 클래스
		OuterClass.InnerClass inn = oc.new InnerClass();
		System.out.println("inn.num:"+inn.num);
		System.out.println("inn.str2:"+inn.str2);
		
		// static inner 클래스
		OuterClass.SInnerClass si = new OuterClass.SInnerClass();
		System.out.println("si.num:"+si.num);
		System.out.println("si.str3:"+si.str3);
		
		// 익명(anonymous) 클래스 : 이름이 없는 클래스. 주로 메서드를 재정의 하는 목적으로 사용.
		new AnonymousClass() {
			
			@Override
			public void method() {
				System.out.println("-- AnonymousClass's Override method --");
			};
		}.method();
		
		// 인터페이스(interface) : 클래스와 다르게 객체를 생성할 수 없음. 클래스에서 구현해야 하는 작업 명세서.
		interfaceA ia = new ImplementClass();
		interfaceB ib = new ImplementClass();
	
		ia.funA();
		ib.funB();
		
		// 추상클래스(Abstract Class) : 인터페이스와 비슷한 형태. 구체화되지 않은 멤버를 이용해서 만들어진 클래스.
		AbstractClassEx ex = new ClassEx(10,"java");
		ex.fun1();
		ex.fun2();
		
		// 람다식 : 기존의 객체 지향이 아닌 함수 지향의 프로그래밍 방법. 익명 함수(anonymous function)를 이용해서 익명 객체를 생성하기 위한 식.
		// 매개변수와 실행문만으로 작성. (접근자, 반환형, return 키워드 생략)
		LambdaInterface1 li1 = (String s1, String s2, String s3) -> {System.out.println(s1+" "+s2+" "+s3);};
		li1.method("Hello", "java", "world");
		
		// 매개변수가 1개이거나 타입이 같을 때, 타입을 생략할 수 있다.
		LambdaInterface2 li2 = (s1) -> {System.out.println(s1);};
		li2.method("Hello");
		
		// 실행문이 1개일 때 '{}'를 생략할 수 있다.
		LambdaInterface2 li3 = (s1) -> System.out.println(s1);
		li3.method("Hello");
		
		// 매개변수와 실행문이 1개일 때, '()'와 '{}'를 생략할 수 있다.
		LambdaInterface2 li4 = s1 -> System.out.println(s1);
		li4.method("Hello");
		
		// 매개변수가 없을 때, '()'만 작성한다.
		LambdaInterface3 li5 = () -> System.out.println("no paremeter");
		li5.method();
		
		// 반환값이 있는 경우
		LambdaInterface4 li6 = (x,y) -> {
			int result = x + y;
			return result;
		};
		System.out.printf("li6.method(10,20):%d\n", li6.method(20, 10));

	
	}

}
