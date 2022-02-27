package lec01Pjt001;

import java.util.Scanner;

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
		
		// 배열 : 인덱스를 이용해서 자료형이 같은 데이터를 관리하는 것
		
		// 배열 선언 후 초기화
		int[] arr1 = new int[5];
		arr1[0] = 100;
		arr1[1] = 200;
		arr1[2] = 300;
		arr1[3] = 400;
		arr1[4] = 500;
		
		// 배열 선언과 초기화를 동시에
		int[] arr2 = {10, 20, 30, 40, 50};
		
		// 조건문 1
		int num1 = 10;
		int num2 = 20;
		if (num1 < num2) {
			System.out.println("num1는 num2보다 작다.");
		} else if (num1 > num2) {
			System.out.println("num1은 num2보다 크다.");
		} else {
			System.out.println("num1과 num2는 같다.");
		}
		
		// 조건문 2
		System.out.println("점수를 입력하세요. : ");
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		
		switch (score){
			case 100:
			case 90:
			System.out.println("수");
			
			case 80:
			System.out.println("우");
			break;
				
			case 70:
			System.out.println("미");
			break;
			
			default:
			System.out.println("Try again!");
			break;
		}
		inputNum.close();
		
		// 반복문 1
		System.out.println("INPUT NUMBER : ");
		Scanner scanner = new Scanner(System.in);
		int inputNum2 = scanner.nextInt();
		for (int i2 = 1; i < 10; i2++) {
			System.out.printf("%d * %d = %d\n", inputNum2, i2, (inputNum2*i2));
		}
		
		// 반복문 2
		int i3 = 10;
		do {
			System.out.println("무조건 1번은 실행합니다.");
			i++;
		} while (i < 13); // 3번 실행됨.
		
		// 상속
		RealChildClass child = new RealChildClass();
		child.parentFun();
		child.childFun();
		// child.privateFun(); // private은 상속되지 않는다.

		ParentClass[] pArr = new ParentClass[2];
		
		FirstChildClass fch = new FirstChildClass();
		SecondChildClass sch = new SecondChildClass();
		
		pArr[0] = fch;
		pArr[1] = sch;
		
		for (i=0; i < pArr.length;i++) {
			pArr[i].makeJjajang();
		}
		
	}

}
