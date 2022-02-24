package testPjt;

public class MainClass {
	
	public static void main(String[] args) {
		Grandeur myCar1 = new Grandeur();
		myCar1.color = "red";
		myCar1.gear = "auto";
		myCar1.price = 3000000;
		
		myCar1.run();
		myCar1.stop();
		myCar1.info();
		
		System.out.println();
		
		Grandeur myCar2 = new Grandeur();
		myCar2.color = "blue";
		myCar2.gear = "manual";
		myCar2.price = 25000000;
		
		myCar1.run();
		myCar1.stop();
		myCar1.info();
		
		Bicycle myBicycle = new Bicycle("red", 100);
		/*
		 * myBicycle.color = "red"; myBicycle.price = 100;
		 */
		myBicycle.info(); // red,100으로 나옴
		
		myBicycle.color = "yellow"; // color가 덧씌워져서 yellow,100으로 나옴
		myBicycle.info();
		
		ChildClass child1 = new ChildClass();
		child1.getInfo(); // 지정 아무것도 안 했으니 모두 nullㄹ 나옴
		child1.setInfo("가나다", "여자", 31);
		child1.getInfo(); // 가나다,여자,31로 나옴.
		
		ObjectClass obj1 = new ObjectClass();
		ObjectClass obj2 = new ObjectClass();
		ObjectClass obj3 = new ObjectClass();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		// 자료형이 ObjectClass로 같아도 다른 공간에 존재하는 객체는 다른 객체임.
		// 즉, obj1과 obj2와 obj3은 모두 다른 객체임.
		
		obj1.getInfo(); // 실행 잘 됨
		obj1 = null; // 레퍼런스 X
		obj1.getInfo(); // NullPointerException 나옴
		
		Student student1 = new Student("일지매",90);
		student1.getInfo();
		
	}

}
