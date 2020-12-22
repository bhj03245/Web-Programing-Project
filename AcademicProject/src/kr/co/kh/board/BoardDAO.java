package kr.co.kh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	protected String sql; 
	protected PreparedStatement pstmt;
	protected Connection conn; 
	protected int cnt;
	protected ResultSet rs;
	protected ArrayList<BoardDTO> boardList;
	protected BoardDTO boardDTO;
	protected BoardDAO boardDAO;
	
	public BoardDAO() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!"); //cafe24 배포 이후 
		return conn;
	}
	
	public void boardClose() {
		try {
			conn.close();
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int boardWrite(BoardDTO boardDTO) throws SQLException{ //게시판  글 작성
		conn = getConnection();
		sql = "insert into boardhj(title, content, author, nal, readcount) values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, boardDTO.getTitle());
	    pstmt.setString(2, boardDTO.getContent());
	    pstmt.setString(3, boardDTO.getAuthor());
	    pstmt.setString(4, boardDTO.getNal());
	    pstmt.setInt(5, boardDTO.getReadcount());
		cnt = pstmt.executeUpdate();
		return cnt;			
	} //게시판 글 작성
	
	public ArrayList<BoardDTO> boardList() throws SQLException{ //게시판 글 목록
		conn = getConnection();
		sql = "select no, title, content, author, nal, readcount from boardhj order by no";
		pstmt = conn.prepareStatement(sql);
		rs =  pstmt.executeQuery();
		boardList = new ArrayList<BoardDTO>();
		while(rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setNo(rs.getInt("no"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContent(rs.getString("content"));
			boardDTO.setAuthor(rs.getString("author"));
			boardDTO.setNal(rs.getString("nal"));
			boardDTO.setReadcount(Integer.parseInt(rs.getString("readcount")));
			boardList.add(boardDTO);
		}
		return boardList;
	} //게시판 글 목록
	
	public int boardDelete(int no) throws SQLException{ //게시판 글 삭제
		conn = getConnection();
		sql = "delete from boardhj where no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		cnt = pstmt.executeUpdate();
		return cnt;
	} //게시판 글 삭제 
	
	public BoardDTO boardSearch(String searchTitle) throws SQLException{ //게시판 글 검색
		conn = getConnection();
		sql = "select no, title, content, author, nal, readcount from boardhj where title=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchTitle);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			boardDTO.setNo(rs.getInt("no"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setContent(rs.getString("content"));
			boardDTO.setAuthor(rs.getString("author"));
			boardDTO.setNal(rs.getString("nal"));
			boardDTO.setReadcount(rs.getInt("readcount"));
		}
		return boardDTO;
	} //게시판 글 검색 
	
	public void boardReadCount(BoardDTO boardDTO) throws SQLException{ //조회수 
		conn = getConnection();
		sql = "update boardhj set readcount=? where no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardDTO.getReadcount()+1);
		pstmt.setInt(2, boardDTO.getNo());
		cnt = pstmt.executeUpdate();
	} //조회수
	
	public int boardUpdate(BoardDTO boardDTO, String searchTitle) throws SQLException{ //게시판 글 수정
			conn = getConnection();
			sql = "update boardhj set title=?, content=?, author=?, nal=?, readcount=? where title=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardDTO.getTitle());
			pstmt.setString(2,boardDTO.getContent());
			pstmt.setString(3,boardDTO.getAuthor());
			pstmt.setString(4,boardDTO.getNal());
			pstmt.setInt(5, boardDTO.getReadcount());
			pstmt.setString(6, searchTitle);
			cnt = pstmt.executeUpdate();
			return cnt;
	} //게시판 글 수정
}
