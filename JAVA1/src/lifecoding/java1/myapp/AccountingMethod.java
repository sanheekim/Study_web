package lifecoding.java1.myapp;

public class AccountingMethod {
	
	// main 함수 바깥에서 선언했기에 지역변수가 아닌 '전역변수'
	public static double valueOfSupply;
	public static double vatRate;
	private static double expenseRate;

	public static void main(String[] args) {
		
		valueOfSupply = 10000.0;
		vatRate = 0.1;
		expenseRate = 0.3;
		
		double vat = getVat();
		double total = getTotal();
		double expense = getExpense();
		double income = getIncome();
		
		double dividend1 = getDiviend1();
		double dividend2 = getDiviend2();
		double dividend3 = getDiviend3();

		print();
		
	}

	private static void print() {
		System.out.println("Value of supply(공급가) : "+ valueOfSupply);
		System.out.println("VAT(부가가치세) : "+ getVat());
		System.out.println("Total(판매가) : "+ getTotal());
		System.out.println("Expense(비용) : "+ getExpense());
		System.out.println("Income(순이익) : "+ getIncome());
		System.out.println("Dividend(배당)1 : " + getDiviend1());
		System.out.println("Dividend(배당)2 : " + getDiviend2());
		System.out.println("Dividend(배당)3 : " + getDiviend3());
	}

	private static double getDiviend1() {
		return getIncome() * 0.5;
	}
	
	private static double getDiviend2() {
		return getIncome() * 0.3;
	}
	
	private static double getDiviend3() {
		return getIncome() * 0.2;
	}

	private static double getIncome() {
		return valueOfSupply - getExpense();
	}

	private static double getExpense() {
		return valueOfSupply * expenseRate;
	}

	private static double getTotal() {
		return valueOfSupply + getVat();
	}
	
	public static double getVat() {
		return valueOfSupply * vatRate;
	}

}
