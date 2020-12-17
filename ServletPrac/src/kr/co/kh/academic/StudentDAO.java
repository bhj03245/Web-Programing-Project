package kr.co.kh.academic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	private String sql; 
	private PreparedStatement pstmt;
	private Connection conn; 
	private int cnt;
	private ResultSet rs;
	private ArrayList<StudentDTO> studentList;
	
	public StudentDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		studentList = new ArrayList<StudentDTO>();
	}
	
	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
		return conn;
	}
	
	public void studentRegisterSql(StudentDTO studentDTO) throws SQLException{
		String sql = "insert into studenthj(age, name, hakbun) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,studentDTO.getAge());
		pstmt.setString(2,studentDTO.getName());
		pstmt.setString(3,studentDTO.getHakbun());	
	}
	
	public int studentExecuter() throws SQLException{
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet studentExecuter(ResultSet rs) throws SQLException{
			rs = pstmt.executeQuery();
			return rs;
	}	
	
	public ResultSet studentListSql() throws SQLException{
		conn = getConnection();
		sql = "select no,age,name,hakbun from studenthj";
		pstmt = conn.prepareStatement(sql);
		rs = studentExecuter(rs);
		return rs;
	}
	
	public int studentDeleteSql(String deleteName) throws SQLException{
		conn = getConnection();
		sql = "delete from studenthj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteName);
		cnt = studentExecuter();
		return cnt;
	}
	
	public ResultSet studentSearchSql(String searchName) throws SQLException{
		conn = getConnection();
		sql = "select no, age, name, hakbun from studenthj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchName);
		rs = studentExecuter(rs);
		return rs;
	}
	
	public int studentUpdateSql(String updateName, StudentDTO studentDTO) throws SQLException{
		conn = getConnection();
		sql = "update studenthj set age = ?, name = ?, hakbun = ? where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, studentDTO.getAge());
		pstmt.setString(2, studentDTO.getName());
		pstmt.setString(3, studentDTO.getHakbun());
		pstmt.setString(4, updateName);
		cnt = studentExecuter();
		return cnt;
	}
}
