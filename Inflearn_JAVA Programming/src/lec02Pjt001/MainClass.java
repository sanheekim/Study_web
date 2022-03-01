package lec02Pjt001;

import java.util.ArrayList;
import java.util.HashMap;

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

		// String 클래스 : String은 데이터가 변화하면 기존의 객체를 버리고 새로운 객체를 메모리에 생성해서 메모리를 많이 잡아먹음.
		// (기존 객체는 Garbage Collector에 의해서 메모리 회수가 이루어짐.)
		String str = "JAVA";
		str = str + "_8";
		
		// StringBuffer, StringBuilder 클래스 : String 클래스의 단점을 보완한 클래스로, 데이터가 변경되면 '메모리에서 기존 객체를 재활용'함.
		// (둘은 거의 똑같은 클래스. Buffer가 나온 후 Builder가 나옴. 데이터안정성은 Buffer가 조금 더 좋고, 속도는 Builder가 더 빠름.)
		StringBuffer sf = new StringBuffer("JAVA");
		sf.append("_8");
		
		// ***** Collections - List [], Map {} *****
		// List : 인터페이스임. 이를 구현한 클래스는 '인덱스'를 이용해서 데이터를 관리함. 데이터 중복이 가능함. ex) Vector, ArrayList, LinkedList
		ArrayList<String> list = new ArrayList<String>();
		// 데이터 추가
		list.add("Hello");
		list.add("Java");
		list.add("World");
		list.add(2,"Programing"); // 추가 // Hello Java Programing World
		list.set(1, "C"); // 변경 // Hello C Programing World
		// 데이터 추출
		String strList = list.get(2);
		System.out.println(strList); // Programing
		// 데이터 제거
		strList = list.remove(2); // Hello C World
		// 데이터 저네 제거
		list.clear();
		// 데이터 유무
		boolean b = list.isEmpty();
		System.out.println(b); // true
		
		// Map : 인터페이스임. 이를 구현한 클래스는 'Key'를 이용해서 데이터 관리함. key는 중복 불가능. 데이터 중복 가능. ex) HashMap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// 데이터 추가
		map.put(5, "Hello"); // key값이 5일 때 "Hello" 넣기
		map.put(6, "Java");
		map.put(7, "World");
		map.put(8, "!");
		// 데이터 교체
		map.put(6, "C");
		// 데이터 추출
		String strMap = map.get(5);
		System.out.println(strMap); // Hello
		// 데이터 제거
		map.remove(8); // {5=Hello, 6=C, 7=World}
		// 특정데이터 포함 유무
		b = map.containsKey(7); // true
		b = map.containsValue("World"); // true
		// 데이터 전체 제거
		map.clear(); // {}
		// 데이터 유무
		b = map.isEmpty(); // true
	}

}
