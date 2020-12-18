package kr.co.kh.academic;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IStudentDAO {
	public abstract void studentRegisterSql(StudentDTO studentDTO) throws SQLException;
	
	public abstract ResultSet studentListSql() throws SQLException;

	
	public abstract int studentDeleteSql(String deleteName) throws SQLException;

	
	public abstract ResultSet studentSearchSql(String searchName) throws SQLException;

	
	public abstract int studentUpdateSql(String updateName, StudentDTO studentDTO) throws SQLException;
}
