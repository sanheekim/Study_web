package lec03Pjt001;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputClass {
	
	public static void main(String[] args) {
		
		//write()
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C:\\KHDev\\java.txt");
			String data = "Hello java world!";
			byte[] arr = data.getBytes();
			
			try {
				outputStream.write(arr);
				// outputStream.write(arr,0,5);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
