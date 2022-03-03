package lec03Pjt001;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputClass {

	public static void main(String[] args) {
		
		// read()
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("C:\\KHDev\\java.txt");
			int data = 0;
			// byte[] bs = new byte[3];
			
			while(true) {
				try {
					data = inputStream.read();
					//data = inputStream.read(bs);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (data == -1) break;
				System.out.println("data : "+data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputStream != null) inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
