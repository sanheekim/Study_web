package lifecoding.java1.basic;
import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class ProgrammingInput {
	
	public static void main(String[] args) {
		
		// 사용자가 입력한 값에 따라서 다른 동작을 하게 됨. swing라는 기술임. (import 확인하기.)
		String id = JOptionPane.showInputDialog("Enter a ID");
		// 빛 값 넣어줄 수 있도록 하기.
		String bright = JOptionPane.showInputDialog("Enter a ID");
		
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
		
		// 밝기를 조절할 수 있음.
		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		// moodLamp.setBright(10); // 10%의 밝기
		moodLamp.setBright(Double.parseDouble(bright)); // 입력한 bright 값을 double(실수)로 출력해줌.
		moodLamp.on();
	}

}
