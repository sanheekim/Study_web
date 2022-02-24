package testPjt;

public class Student {
	
	private String name;
	private int score;
	
	public Student(String n, int s) {
		this.name = n;
		this.score = s;
	}
	
	public void getInfo() {
		System.out.println("--getInfo()--");
		System.out.println("name:"+name); 
		System.out.println("score:"+score); 
	}

}
