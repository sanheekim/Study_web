package testPjt;

public class Bicycle {
	
	public String color;
	public int price;
	
	public Bicycle() {
		System.out.println("Bycicle constructor 1 ");
	}
	
	public Bicycle(String c, int p) {
		System.out.println("Bycicle constructor 2 ");
		this.color = c;
		this.price = p;
	}
	
	public void info() {
		System.out.println("--info()--");
		System.out.println("color : "+color);
		System.out.println("price : "+price);
	}

}
