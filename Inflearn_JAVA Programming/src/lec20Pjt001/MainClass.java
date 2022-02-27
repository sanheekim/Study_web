package lec20Pjt001;

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
		
	}

}
