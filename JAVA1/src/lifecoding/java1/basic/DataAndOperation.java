package lifecoding.java1.basic;

public class DataAndOperation {
	public static void main(String[] args) {
		
		System.out.println(6); // Number
		System.out.println("six"); // String
		
		System.out.println("6"); // String 6, 사람이 보기엔 숫자지만 컴퓨터는 "" 때문에 문자로 인식.
		
		System.out.println(6+6); // 12
		System.out.println("6"+"6"); // 66
		
		System.out.println(6*6); // 36
		// System.out.println("6"*"6"); // error. 문자열이란 데이터타입은 곱할 수 없기 때문.
		
		System.out.println("1111".length()); // 4
		// System.out.println(1111.length()); // error. 숫자는 길이를 알 수 없다. 
		
	}
}
