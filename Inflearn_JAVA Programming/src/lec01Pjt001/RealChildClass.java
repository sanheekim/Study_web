package lec01Pjt001;

public class RealChildClass extends ParentClass {
	
	public RealChildClass() {
		System.out.println("ChildClass constructor");
	}
	
	public void childFun() {
		System.out.println("--ChildFun() START--");
	}
	
	//Override 재정의
	public void makeJjajang() {
		System.out.println("--more makeJjajang--");
	}

}
