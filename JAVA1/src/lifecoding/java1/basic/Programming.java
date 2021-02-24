package lifecoding.java1.basic;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class Programming {
	
	public static void main(String[] args) {
		
		String id = "JAVA APT 507";
		
		// Elevator call
		// myElevator라는 변수는 반드시 Elevator라는 데이터타입에 해당되는 데이터만 올 수 있음.
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1); // 1층에서 올라감 버튼 누름. 엘리베이터를 1층으로 보내라는 뜻.
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		
		// Light on
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / floorLamp");
		floorLamp.on();
		
	}

}
