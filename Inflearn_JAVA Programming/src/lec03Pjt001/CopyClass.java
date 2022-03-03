package lec03Pjt001;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyClass {
	
	public static void main(String[] args) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = new FileInputStream("C:\\KHDev\\java.txt");
			outputStream = new FileOutputStream("C:\\\\KHDev\\\\javaCopy.txt");
			
			byte[] arr = new byte[3];
			
			while(true) {
				int len = inputStream.read(arr);
				if(len==-1) break;
				outputStream.write(arr, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {e.printStackTrace();}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Exception e) {e.printStackTrace();}
			}
		}
	}
	
}
