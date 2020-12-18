package kr.co.kh.academic;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfessorDAO extends AcademicDAO implements IProfessorDAO{

	public ProfessorDAO() throws ClassNotFoundException{
	
	}
	
	@Override
	public void professorRegisterSql(ProfessorDTO professorDTO) throws SQLException{
		String sql = "insert into professorhj(age, name, subject) values(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,professorDTO.getAge());
		pstmt.setString(2,professorDTO.getName());
		pstmt.setString(3,professorDTO.getSubject());	
	}
	
	@Override
	public ResultSet professorListSql() throws SQLException{
		conn = getConnection();
		sql = "select no,age,name,subject from professorhj";
		pstmt = conn.prepareStatement(sql);
		rs = professorExecuter(rs);
		return rs;
	}
	
	@Override
	public int professorDeleteSql(String deleteName) throws SQLException{
		conn = getConnection();
		sql = "delete from professorhj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, deleteName);
		cnt = professorExecuter();
		return cnt;
	}
	
	@Override
	public ResultSet professorSearchSql(String searchName) throws SQLException{
		conn = getConnection();
		sql = "select no, age, name, subject from professorhj where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchName);
		rs = professorExecuter(rs);
		return rs;
	}
	
	@Override
	public int professorUpdateSql(String updateName, ProfessorDTO professorDTO) throws SQLException{
		conn = getConnection();
		sql = "update professorhj set age = ?, name = ?, subject = ? where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, professorDTO.getAge());
		pstmt.setString(2, professorDTO.getName());
		pstmt.setString(3, professorDTO.getSubject());
		pstmt.setString(4, updateName);
		cnt = professorExecuter();
		return cnt;
	}
}


