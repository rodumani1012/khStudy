package io.buffered.run;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedPrec {
	public static void main(String[] args) {
		byte[] bt = new byte[1024];
		//�Է�
		BufferedInputStream bis = null;
		//���
		BufferedOutputStream bos = null;

		System.out.println("�Է��Ѱ��� ���ϰ� ����Ϳ� ���");
		System.out.println("=============================");
		
		try {
		bis = new BufferedInputStream(System.in);
		System.out.println("�Է�: ");
			bis.read(bt);
			
			
			bos = new BufferedOutputStream(new FileOutputStream("input.txt"));
			bos.write(bt);
			
			System.out.print("���: ");
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
		
		
		
		
		
		
		
		
		
		
		
		//�Է� : Ű����
		//BufferedInputStrem(System.in, 1024)
		
		
		//��� : ����� + input.txt
		//BufferedOutputStream(FileOutputStream("input.txt"));
		
		
	}

}
