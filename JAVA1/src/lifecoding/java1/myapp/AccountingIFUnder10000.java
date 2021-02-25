package lifecoding.java1.myapp;

// 사용자가 10,000원보다 작은 금액을 계산할 때는 이걸 사용하도록 함.
public class AccountingIFUnder10000 {

	public static void main(String[] args) {
		
		double valueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply * vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		
		double dividend1 = income * 1.0;
		double dividend2 = income * 0;
		double dividend3 = income * 0;
		
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
