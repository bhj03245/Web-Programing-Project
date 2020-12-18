package kr.co.kh.academic;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ManagerDAO extends AcademicDAO implements IManagerDAO{	
	public ManagerDAO() throws ClassNotFoundException{
	
	}
	
	@Override
	public void managerRegisterSql(ManagerDTO managerDTO) throws SQLException{
		String sql = "insert into managerhj(age, name, part) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,managerDTO.getAge());
		pstmt.setString(2,managerDTO.getName());
		pstmt.setString(3,managerDTO.getPart());	
	}
	
	@Override
	public ResultSet managerListSql() throws SQLException{
		conn = getConnection();
		sql = "select no,age,name,part from managerhj";
		pstmt = conn.prepareStatement(sql);
		rs = managerExecuter(rs);
		return rs;
	}
	
	@Override
	public int managerDeleteSql(String deleteName) throws SQLException{
		conn = getConnection();
		sql = "delete from managerhj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteName);
		cnt = managerExecuter();
		return cnt;
	}
	
	@Override
	public ResultSet managerSearchSql(String searchName) throws SQLException{
		conn = getConnection();
		sql = "select no, age, name, part from managerhj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchName);
		rs = managerExecuter(rs);
		return rs;
	}
	
	@Override
	public int managerUpdateSql(String updateName, ManagerDTO managerDTO) throws SQLException{
		conn = getConnection();
		sql = "update managerhj set age = ?, name = ?, part = ? where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, managerDTO.getAge());
		pstmt.setString(2, managerDTO.getName());
		pstmt.setString(3, managerDTO.getPart());
		pstmt.setString(4, updateName);
		cnt = managerExecuter();
		return cnt;
	}
}
