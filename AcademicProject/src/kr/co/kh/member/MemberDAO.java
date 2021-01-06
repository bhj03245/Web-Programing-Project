package kr.co.kh.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.kh.board.BoardDTO;

public class MemberDAO {
	private MemberDTO memberDTO;
	private ArrayList<MemberDTO> memberList;
	private Connection conn; 
	private PreparedStatement pstmt;
	private String sql;
	private ResultSet rs;
	int cnt;
	
	public MemberDAO(){
		memberDTO = new MemberDTO();
		memberList = new ArrayList<MemberDTO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
		return conn;
	}
	
	public int memberRegister(MemberDTO memberDTO) throws SQLException{
		conn = getConnection();
		sql = "insert into memberhj(id,pw,addr,tel) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,memberDTO.getId());
		pstmt.setString(2,memberDTO.getPw());
		pstmt.setString(3, memberDTO.getAddr());
		pstmt.setString(4, memberDTO.getTel());
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ArrayList<MemberDTO> memberList() throws SQLException{
		conn = getConnection();
		sql = "select id, pw, addr, tel from memberhj";
		pstmt = conn.prepareStatement(sql);
		rs =  pstmt.executeQuery();
		memberList = new ArrayList<MemberDTO>();
		while(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setTel(rs.getString("tel"));
			memberList.add(memberDTO);
		}
		return memberList;
	}
	
	public int memberDelete(String deleteId, String deletePw) throws SQLException{
		conn = getConnection();
		sql = "delete from memberhj where id = ? and pw = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteId);
		pstmt.setString(2, deletePw);
		cnt = pstmt.executeUpdate();
		return cnt; 
	}
	
	public MemberDTO memberLogin(String id, String pw) throws SQLException{
		conn = getConnection();
		sql = "select id, pw from memberhj where id=? and pw=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		rs = pstmt.executeQuery();
		while(rs.next()){
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
		}
		return memberDTO;
	}
	
	public String memberidCheck(String tel) throws SQLException{
		conn = getConnection();
		sql = "select id from memberhj where tel=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, tel);
		rs=pstmt.executeQuery();
		String id = null;
		while(rs.next()) {
			id = rs.getString("id");
		}
		return id;
	}
	
	public String memberpwCheck(String id) throws SQLException{
		conn = getConnection();
		sql = "select pw from memberhj where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		String pw = null;
		while(rs.next()) {
			pw = rs.getString("pw");
		}
		return pw;
	}
	
	public MemberDTO memberUpdateConfirm(String id) throws SQLException{
		conn = getConnection();
		sql = "select id, pw, addr, tel from memberhj where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setTel(rs.getString("tel"));
		}
		return memberDTO;
	}
	
	public int memberUpdateFinal(MemberDTO memberDTO, String updateID) throws SQLException{
		conn = getConnection();
		sql = "update memberhj set id=?,pw=?,addr=?,tel=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPw());
		pstmt.setString(3, memberDTO.getAddr());
		pstmt.setString(4, memberDTO.getTel());
		pstmt.setString(5, updateID);
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet IDcheck(String searchId) throws SQLException{
		conn = getConnection();
		sql = "select id from memberhj where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,searchId);
		rs = pstmt.executeQuery();
		return rs;
	}
}
