package lec01Pjt001;

public class MainClass {
	
	public static void main(String[] args) {
		System.out.println("Hello, Java World! \nNice to meet you again");
		// F11 누르면 실행
		// java programming을 하려면 jdk ∋ jre ∋ api ∋ jvm 을 사용해야 함.
	
		int i; // 변수 선언
		i = 10; // 변수 초기화
		System.out.println("i="+i);
		
		int j = 20; // 변수 선언과 초기화를 동시에 진행
		System.out.println("j="+j);
		
		// 자동(묵시적) 형변환: 작은 공간의 메모리에서 큰 공간의 메모리로 이동
		byte by = 10;
		int in = by;
		System.out.println(in); // 10
		
		// 명시적 형변환 : 큰 공간의 메모리에서 작은 공간의 메모리로 이동
		int iVar = 100;
		byte bVar = (byte)iVar;
		System.out.println(bVar); // 100
		
		iVar = 123456;
		bVar = (byte)iVar;
		System.out.println(bVar); //64 => 명시적 형변환은 데이터가 누슬될 수 있음. 
	
		System.out.println("Good\tMorning");
		System.out.println("Good\nMorning");
		System.out.println("Good\'Morning");
		System.out.println("Good\"Morning");
		System.out.println("Good\\Morning");
		
		// 서식문자
		System.out.printf("오늘의 기온은 %d도 입니다.\n", 10);
		// %d = 10진수
		// %o = 8진수
		// %x = 16진수
		// %c = 문자
		// %s = 문자열
		// %f = 실수
		
		// 대입 연산자 : '오른쪽'의 결과를 '왼쪽'에 대입(할당) 함
		
	}

}
