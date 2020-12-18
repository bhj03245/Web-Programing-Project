package kr.co.kh.academic;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IManagerDAO {
	public abstract void managerRegisterSql(ManagerDTO managerDTO) throws SQLException;
	
	public abstract ResultSet managerListSql() throws SQLException;
	
	public abstract int managerDeleteSql(String deleteName) throws SQLException;
	
	public abstract ResultSet managerSearchSql(String searchName) throws SQLException;
	
	public abstract int managerUpdateSql(String updateName, ManagerDTO managerDTO) throws SQLException;
}
