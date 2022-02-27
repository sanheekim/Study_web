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
	}

}
