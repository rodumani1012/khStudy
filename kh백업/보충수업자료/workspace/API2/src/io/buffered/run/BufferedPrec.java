package io.buffered.run;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedPrec {
	public static void main(String[] args) {
		byte[] bt = new byte[1024];
		//입력
		BufferedInputStream bis = null;
		//출력
		BufferedOutputStream bos = null;

		System.out.println("입력한것을 파일과 모니터에 출력");
		System.out.println("=============================");
		
		try {
		bis = new BufferedInputStream(System.in);
		System.out.println("입력: ");
			bis.read(bt);
			
			
			bos = new BufferedOutputStream(new FileOutputStream("input.txt"));
			bos.write(bt);
			
			System.out.print("출력: ");
			System.out.println(new String(bt));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		//입력 : 키보드
		//BufferedInputStrem(System.in, 1024)
		
		
		//출력 : 모니터 + input.txt
		//BufferedOutputStream(FileOutputStream("input.txt"));
		
		
	}

}
