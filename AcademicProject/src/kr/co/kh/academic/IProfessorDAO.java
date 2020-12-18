package kr.co.kh.academic;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IProfessorDAO {
	public abstract void professorRegisterSql(ProfessorDTO professorDTO) throws SQLException;
	
	public abstract ResultSet professorListSql() throws SQLException;

	
	public abstract int professorDeleteSql(String deleteName) throws SQLException;

	
	public abstract ResultSet professorSearchSql(String searchName) throws SQLException;

	
	public abstract int professorUpdateSql(String updateName, ProfessorDTO professorDTO) throws SQLException;
}
