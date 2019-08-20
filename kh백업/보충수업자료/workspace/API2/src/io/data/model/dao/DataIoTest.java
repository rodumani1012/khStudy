package io.data.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataIoTest {
	
	public DataIoTest() {}
	
	
	//DataInput/OutputStream -> 바이트, 보조 스트림이다.
	//데이터를 읽느데 1byte 단위X , 기본자료형(8개),String 단위로 읽고쓴다.
	
	public void addDate() {
		
		try(DataOutputStream dout = new DataOutputStream(
								new FileOutputStream("member.txt"))){
			
			//write 엄창 많다!!!! 자료형별로 존재
			dout.writeUTF("이창진");		//이름(String)
			dout.writeInt(20);			//나이(int)
			dout.writeChar('M');		//성별(char)
			dout.writeDouble(188.5);	//키(Double)
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void readData() {
		try(DataInputStream din = new DataInputStream
					(new FileInputStream("member.txt"))){
			
			String name = din.readUTF();
			int age = din.readInt();
			char gender = din.readChar();
			double height = din.readDouble();
			
			System.out.println("name: "+name);
			System.out.println("age: " + age);
			System.out.println("gender: "+gender);
			System.out.println("height: " + height);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	

	public void addData2() {
		Scanner sc = new Scanner(System.in);
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("member.txt"))) {
			while() {
				//1.키보드로 정보입력
				
				//2.입력한 정보 member.txt에 저장
				//3.wirteUTF, writeInt..... 
				//4. 입력을 더 하고싶지 않을땐 while문 종료
			}
		} catch () {
		}
	}
	public void readData2() {
		try {
			while() {
				//member.txt에서 데이터를 읽어 콘솔에 출력
				//1.readUTF, readInt....
			}
		} catch () {
		}
	}
	
	
	
	
	
	
	
	
}
