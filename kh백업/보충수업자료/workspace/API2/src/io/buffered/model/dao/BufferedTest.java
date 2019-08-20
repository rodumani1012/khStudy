package io.buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest {
	public BufferedTest() {}

	//BufferedWriter - 보조스트림
	//FileWriter - 기반스트림
	//외부자원 - sample2.txt
	public void output() {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt"));) {
			bw.write("안녕하세요 여러분");
			bw.write(" 창진쌤입니다.\n");
			bw.write("언제나 항상 여러분들을 응원합니다.");
			bw.newLine();//BufferedWriter에만 있는 메소드.
			bw.write("퐈이팅!!!");
			//개행 : 1) \n 
			//		2) newLisne();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	public void input() {
		
		try(BufferedReader br = new BufferedReader(new FileReader("sample2.txt"))){
			//readLine() - 한줄씩 불러오는 역할을 한다
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			
			String str="";
			while( (str = br.readLine()) !=null) {
				System.out.println(str);
			}
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//sample2.txt에 덮어쓰지 말고 내용을 추가해보자
	
	public void output2() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample2.txt",true));) {
			
			
			bw.write("오늘은 목요일...ㅜㅜ");
			bw.write("내일은 금요일!!!!!!!!");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
	
	
	
	
	
}
