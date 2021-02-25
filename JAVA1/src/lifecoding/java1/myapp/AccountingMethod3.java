package lifecoding.java1.myapp;

public class AccountingMethod3 {

	public static void main(String[] args) {
		
		double valueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply * vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		
		double dividend1 = income * 0.5;
		double dividend2 = income * 0.3;
		double dividend3 = income * 0.2;

		System.out.println("Value of supply(공급가) : "+ valueOfSupply);
		System.out.println("VAT(부가가치세) : "+ vat);
		System.out.println("Total(판매가) : "+ total);
		System.out.println("Expense(비용) : "+ expense);
		System.out.println("Income(순이익) : "+ income);
		System.out.println("Dividend(배당)1 : " + dividend1);
		System.out.println("Dividend(배당)2 : " + dividend2);
		System.out.println("Dividend(배당)3 : " + dividend3);
	}

}
