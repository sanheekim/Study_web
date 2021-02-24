package lifecoding.java1.basic;

public class Variable {
	
	public static void main(String[] args) {
		
		// a = 1; // 데이터타입이 명시 안 돼서 error
		int a = 1; // Number -> integer(=정수)
		System.out.println(a);
		
		// int b = 1.1; // 1.1은 정수가 아닌 실수(real number)이므로 error
		double b = 1.1; // Real Number -> double(=실수)
		
		String c = "Hello World";
		System.out.println(c);
		
		String name = "sanhee";
		System.out.println("Hello, sanhee ... sanhee ... sanhee ...bye");
		System.out.println("Hello, "+name+" ... "+name+" ... sanhee ...bye");
		
		double VAT = 10.0;
		System.out.println(10.0);
		System.out.println(VAT);
		
		// CASTING : 데이터 타입을 변환하는 것
		double d = 1.1;
		double e = 1;
		double e2 = (double) 1;
		System.out.println(e); // 1이지만 double이니까 자동으로 1.0이 나옴.
		System.out.println(e2);
		int f = (int) 1.1; // (int) : 1.1은 double인데 그걸 강제로 int로 바꾸겠다는 뜻.
		System.out.println(f);
		
		// 1 to String
		String g = Integer.toString(1);
		System.out.println(g); // 숫자가 아니라문자열 1이 나옴.
		System.out.println(g.getClass()); // getClass는 변수 g가 갖고 있는 값이 어떤 데이터타입인지 알려줌. // class java.lang.String
		
	}

}
