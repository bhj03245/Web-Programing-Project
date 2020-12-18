package kr.co.kh.academic;


import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO extends AcademicDAO implements IStudentDAO{
	public StudentDAO() throws ClassNotFoundException{
		
	}
	
	@Override
	public void studentRegisterSql(StudentDTO studentDTO) throws SQLException{
		String sql = "insert into studenthj(age, name, hakbun) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,studentDTO.getAge());
		pstmt.setString(2,studentDTO.getName());
		pstmt.setString(3,studentDTO.getHakbun());	
	}
	
	@Override
	public ResultSet studentListSql() throws SQLException{
		conn = getConnection();
		sql = "select no,age,name,hakbun from studenthj";
		pstmt = conn.prepareStatement(sql);
		rs = studentExecuter(rs);
		return rs;
	}
	
	@Override
	public int studentDeleteSql(String deleteName) throws SQLException{
		conn = getConnection();
		sql = "delete from studenthj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteName);
		cnt = studentExecuter();
		return cnt;
	}
	
	@Override
	public ResultSet studentSearchSql(String searchName) throws SQLException{
		conn = getConnection();
		sql = "select no, age, name, hakbun from studenthj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchName);
		rs = studentExecuter(rs);
		return rs;
	}
	
	@Override
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
