package io.file.fileByte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteTest {
	
	//기본생성자
	public FileByteTest() {}
	
	//바이트 기반스트림으로 바이단위로 데이터를 전송
	//FileInput/OutputStream
	
	//Save
	public void fileSave() {
//		File file = new File("test.txt");
//		
//		try {
//			FileOutputStream fout = new FileOutputStream("sample.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("sample.txt");
			
			//FileOutputStream이 제공해주는 메서드 사용
			//write(); 3가지
			
			//write(int)
			fout.write(65);
			
			
			//write(byte[])
			byte[] barr = new byte[] {97,98};
			fout.write(barr);
			
			
			//write(byte[], int ,int)
			fout.write(barr, 0, 1);
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public void fileRead() {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("sample.txt");
			
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			
			//반복문
			int temp=0;
			while((temp=fis.read()) != -1) {
				System.out.println((char)temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
