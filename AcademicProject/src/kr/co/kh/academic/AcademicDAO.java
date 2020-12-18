package kr.co.kh.academic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicDAO {
	protected String sql; 
	protected PreparedStatement pstmt;
	protected Connection conn; 
	protected int cnt;
	protected ResultSet rs;
	
	public AcademicDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
		return conn;
	}
	
	public int studentExecuter() throws SQLException{
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet studentExecuter(ResultSet rs) throws SQLException{
			rs = pstmt.executeQuery();
			return rs;
	}
	
	public int professorExecuter() throws SQLException{
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet professorExecuter(ResultSet rs) throws SQLException{
			rs = pstmt.executeQuery();
			return rs;
	}
	
	public int managerExecuter() throws SQLException{
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet managerExecuter(ResultSet rs) throws SQLException{
			rs = pstmt.executeQuery();
			return rs;
	}	
}
