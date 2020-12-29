package kr.co.kh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO implements IBoard{
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
	
	@Override
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
	
	@Override
	public int totalCount() throws SQLException{ //페이징 처리: 전체 레코드 개수 
		int count = 0;
		conn = getConnection();
		sql = "select count(*) from boardhj";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}
	
	@Override
	public PageTo pageTo(int curPage) throws SQLException{ //페이징 구현
		PageTo pageTo = new PageTo();
		int totalCount = totalCount();
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		conn = getConnection();
		sql = "select no, title, content, author, nal, readcount from boardhj order by no";
		pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
		//TYPE_SCROLL_INSENSITIVE: 스크롤은 가능하나, 변경된 사항은 적용되지 않음
		//양방향 스크롤시 업데이트 반영 안함 
		//CONCUR_READ_ONLY: 커서의 위치에서 정보업데이트 불가, ResultSet의 변경이 불가능
		rs = pstmt.executeQuery();
		int perPage = pageTo.getPerPage();
		int skip = (curPage-1)*perPage;
		
		if(skip>0) {
			rs.absolute(skip);
		} //ResultSet의 Absolute메소드를 이용하여 해당페이지의 Cursor위치로 이동한다. 
		
		for(int i=0;i<perPage && rs.next();i++) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			BoardDTO data = new BoardDTO();
			data.setNo(no);
			data.setTitle(title);
			data.setContent(content);
			data.setAuthor(author);
			data.setNal(nal);
			data.setReadcount(readcount);
			list.add(data);
		}
		pageTo.setList(list);
		pageTo.setTotalCount(totalCount);
		pageTo.setCurPage(curPage);
		
		return pageTo;
	} //페이징 구현
	
	public ArrayList<BoardDTO> boardList() throws SQLException{ //게시판 글 목록(페이징 이전)
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
	} //게시판 글 목록(페이징 이전)
	
	@Override
	public int boardDelete(int no) throws SQLException{ //게시판 글 삭제
		conn = getConnection();
		sql = "delete from boardhj where no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		cnt = pstmt.executeUpdate();
		return cnt;
	} //게시판 글 삭제 
	
	@Override
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
	
	@Override
	public void boardReadCount(BoardDTO boardDTO) throws SQLException{ //조회수 
		conn = getConnection();
		sql = "update boardhj set readcount=? where no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, boardDTO.getReadcount()+1);
		pstmt.setInt(2, boardDTO.getNo());
		cnt = pstmt.executeUpdate();
	} //조회수
	
	@Override
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
