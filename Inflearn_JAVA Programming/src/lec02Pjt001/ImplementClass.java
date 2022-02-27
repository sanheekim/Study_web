package lec02Pjt001;

// 클래스는 1개만 extends로 상속하고, 인터페이스는 n개를 implements로 상속 가능하다.
public class ImplementClass implements interfaceA, interfaceB {
	
	public ImplementClass() {
		System.out.println("ImplementClass constructor");
	}
	
	@Override
	public void funA() {
		System.out.println("--funA()--");
	}
	
	@Override
	public void funB() {
		System.out.println("--funB()--");
	}

}
