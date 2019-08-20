package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 
public class JDBCTemplate {

	public static Connection getConnection() {
		Connection con = null;
		// 1. driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01.driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("01.driver 연결실패");
			e.printStackTrace();
		}
		// 2.��������
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.33:1521:xe", "kh", "kh");
			con.setAutoCommit(false);
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void close(Connection con) {
		try {
			con.close();
			System.out.println("05. driver 종료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollBack(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
