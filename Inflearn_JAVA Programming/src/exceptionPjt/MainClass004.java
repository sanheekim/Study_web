package exceptionPjt;

public class MainClass004 {
	
	public static void main(String[] args) {
		
		MainClass004 mainClass004 = new MainClass004();
		
		try {
			mainClass004.firstMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// throws : 예외 발생 시 예외 처리를 직접 하지 않고 호출한 곳으로 넘긴다.
	public void firstMethod() throws Exception {
		secondMethod();
	}
	
	public void secondMethod() throws Exception {
		thirdMethod();
	}
	
	public void thirdMethod() throws Exception {
		System.out.println("10/0="+(10/0));
	}

}
