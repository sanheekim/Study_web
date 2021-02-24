package lifecoding.java1.myapp;

public class Accounting {

	public static void main(String[] args) {
		
		System.out.println("Value of supply(공급가) : "+10000.0);
		System.out.println("VAT(부가가치세) : "+ (10000.0*0.1));
		System.out.println("Total(판매가) : "+ (10000.0 + 10000.0*0.1));
		System.out.println("Expense(비용) : "+ (10000.0*0.3));
		System.out.println("Income(순이익) : "+ (10000.0 - 10000.0*0.3));
		System.out.println("Dividend(배당)1 : " + (10000.0 - 10000.0*0.3) * 0.5);
		System.out.println("Dividend(배당)2 : " + (10000.0 - 10000.0*0.3) * 0.3);
		System.out.println("Dividend(배당)3 : " + (10000.0 - 10000.0*0.3) * 0.2);
	}

}
