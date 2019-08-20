package com.seoda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.JDBCTemplate;

public class SeodaDao extends JDBCTemplate{
	
private List<Integer> deck = new ArrayList<Integer>();
	
	//	�⺻ ������ ȣ�� �� ī�嵦 ����
	public SeodaDao() {
		this.deck = createDeck();
	}
	
	//	ī�嵦 ����
	public List<Integer> createDeck() {
		int[] special = {1,2,3,4,5,6,7,8,9,10};
		int[] normal= {11,22,33,44,55,66,77,88,99,110};
		
		for(int i = 0 ; i<10 ; i++) {
			deck.add(special[i]);
		}
		for(int i = 0 ; i<10 ; i++) {
			deck.add(normal[i]);
		}
		
		//	���� ���´�
		Collections.shuffle(deck);
		
		return deck;
	}
	
	//	ī�� �̱�(2�徿)
	public int draw() {
		//	���� 0 ���� ī�带 �� �� �̴´�
		Integer drawCard = this.deck.get(0);
		
		//	���� ī��� ����Ʈ���� �����
		this.deck.remove(0);
		
		return drawCard;
	}
	
	//	�¸��� �� ������Ʈ
	public int moneyWinUpdate(String name, int money) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		int res = 0;
		System.out.println(name);
		
		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY + ? WHERE NAME = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, money);
			pstm.setString(2, name);
			
			res = pstm.executeUpdate();
						
			System.out.println("03 / 04 ���� ���� �� ���� : " + sql);
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("03 / 04 ���� ����");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//	�й��� �� ������Ʈ
	public int moneyLoseUpdate(String name, int money) {
		Connection con = getconnection();
		PreparedStatement pstm = null;
		int res = 0;
		System.out.println(name);
		
		String sql = " UPDATE PROJECTBOARD SET MONEY = MONEY - ? WHERE NAME = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, money);
			pstm.setString(2, name);
			
			res = pstm.executeUpdate();
			
			System.out.println("03 / 04 ���� ���� �� ���� : " + sql);
			
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("03 / 04 ���� ����");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
