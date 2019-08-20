package io.conversion.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//매개변수로 외부자원을 선택한다면 기반!
//매개변수로 다른스트림을 선택한다면 보조!
//-> 보조는 단독사용X, 

public class ByteToCharTest {

	public ByteToCharTest() {}
	
	public void input() {
		//키보드로 입력 => Scanner, BufferedReader
		//1. Scanner -> sc.nextInt(), sc.nextDouble()... 
		//자료형에 맞춰서 다른 메소드를 실행해야 한다.
		
		Scanner sc = new Scanner(System.in);
		
		//2. BufferedReader --> br.readLine() 
		//어떠한 값이든 하나로 입력을 한다.(String으로)
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		try {
			System.out.println("값을 입력하세요: ");
			String value = br.readLine();
			System.out.println("value: "+ value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedReader br2 = null;
		
		
		try {
			br2=new BufferedReader(new InputStreamReader
					(new FileInputStream("sample.txt") ));
			
			System.out.println(br2.readLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public void output() {
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
//		OutputStreamWriter osw = new OutputStreamWriter(System.out);
//		BufferedWriter bw = new BufferedWriter(osw);
//		
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			bw.write("hello everyone");
			//bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
