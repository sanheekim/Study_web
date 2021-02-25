package lifecoding.java1.myapp;

public class AccountingArray {

	public static void main(String[] args) {
		
		double valueOfSupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double expenseRate = 0.3;
		double vat = valueOfSupply * vatRate;
		double total = valueOfSupply + vat;
		double expense = valueOfSupply * expenseRate;
		double income = valueOfSupply - expense;
		
		//double rate1 = 0.5;
		//double rate2 = 0.3;
		//double rate3 = 0.2;
		// 위처럼 rate라는 변수명은 흔해서 다른 사람이 이 변수명을 갖고 또 다른 데에 써서 헷갈릴 수 있음.
		// 그걸 방지하기 위해 세 변수를 한 번에 묶어버리는 배열을 만듦.
		
		double[] dividendRates = new double[3];
		dividendRates[0] = 0.5;
		dividendRates[1] = 0.3;
		dividendRates[2] = 0.2;
		
		double dividend1 = income * dividendRates[0];
		double dividend2 = income * dividendRates[1];
		double dividend3 = income * dividendRates[2];

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
