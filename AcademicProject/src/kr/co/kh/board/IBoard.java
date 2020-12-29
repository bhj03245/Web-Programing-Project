package kr.co.kh.board;

import java.sql.SQLException;

public interface IBoard {
	public abstract int boardWrite(BoardDTO boardDTO) throws SQLException;
	public abstract int totalCount() throws SQLException;
	public abstract PageTo pageTo(int curPage) throws SQLException;
	public abstract int boardDelete(int no) throws SQLException;
	public abstract BoardDTO boardSearch(String searchTitle) throws SQLException;
	public abstract void boardReadCount(BoardDTO boardDTO) throws SQLException;
	public abstract int boardUpdate(BoardDTO boardDTO, String searchTitle) throws SQLException;
}
