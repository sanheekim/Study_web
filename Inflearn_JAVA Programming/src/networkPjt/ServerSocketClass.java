package networkPjt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketClass {
	
	public static void main(String[] args) {
		
		// 소켓(Socket) : 네트워크 상에서 데이터를 주고받기 위한 장치
		// 서버에 ServerSocket을 준비하고
		// 클라이언트에서 Socket을 이용해서 접속함
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		try {
			
			serverSocket = new ServerSocket(9000);
			System.out.println("클라이언트 맞을 준비 완료!");
			
			socket = serverSocket.accept();
			System.out.println("클라이언트 연결!");
			System.out.println("socket:"+socket);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			while (true) {
				String clientMessage = dataInputStream.readUTF();
				System.out.println("clientMessage:"+clientMessage);
				
				dataOutputStream.writeUTF("메시지 전송 완료!");
				dataOutputStream.flush();
				
				if(clientMessage.equals("STOP")) break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) socket.close();
				if (serverSocket != null) serverSocket.close();
				if (dataOutputStream!=null) dataOutputStream.close();
				if (outputStream!=null) outputStream.close();
				if (inputStream!=null) inputStream.close();
				if (dataInputStream!=null) dataInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
