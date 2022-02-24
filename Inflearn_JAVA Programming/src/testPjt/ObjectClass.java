package testPjt;


public class ObjectClass {
	
	//매개변수가 없는 디폴트 생성자는 직접 정의해주지 않아도 자동으로 생성됨
	public ObjectClass() { 
		System.out.println("--ObjectClass()--");
	}

	// 사용자 정의 생성자
	public ObjectClass(String s, int[] iArr) { 
		System.out.println("--ObjectClass()--");
		System.out.println(s);
		System.out.println(iArr);
	}
	
	public int x;
	public int y;
	public ObjectClass(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void getInfo() {
		System.out.println("--getInfo()--");
	}
	
}
