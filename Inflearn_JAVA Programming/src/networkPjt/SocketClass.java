package networkPjt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClass {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		Scanner scanner = null;
		
		try {
			socket = new Socket("localhost",9000);
			System.out.println("서버 연결 완료!");
			System.out.println("socket:"+socket);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("메시지 입력.");
				String outMessage = scanner.nextLine();
				dataOutputStream.writeUTF(outMessage);
				dataOutputStream.flush();
				
				String inMessage = dataInputStream.readUTF();
				System.out.println("inMessage:"+inMessage);
				
				if(outMessage.equals("STOP")) break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket!=null) socket.close();
				if (dataOutputStream!=null) dataOutputStream.close();
				if (outputStream!=null) outputStream.close();
				if (inputStream!=null) inputStream.close();
				if (dataInputStream!=null) dataInputStream.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
