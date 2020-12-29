package kr.co.kh.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDTO boardDTO;
	private BoardDAO boardDAO;
	private int cnt;
	private ArrayList<BoardDTO> boardList;
	private String updateTitle;

	public BoardServlet() {
	    try {
			boardDAO = new BoardDAO();
			boardDTO = new BoardDTO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		 if (command.equals("/boardRegister.bo")) { //게시판 등록
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setAuthor(request.getParameter("author"));
			boardDTO.setNal(request.getParameter("nal"));
			boardDTO.setReadcount(Integer.parseInt(request.getParameter("readcount")));
			try {
			   cnt = boardDAO.boardWrite(boardDTO);
			   response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		} //게시판 등록
		
		else if(command.equals("/boardList.bo")) { //게시판 전체 출력(페이징)
			try {
				int curPage = 1; //기본 페이지
				if(request.getParameter("curPage")!=null) {
					curPage = Integer.parseInt(request.getParameter("curPage"));
				}
				PageTo boardList = boardDAO.pageTo(curPage);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/list");
				request.setAttribute("page", boardList);
				//listPage.jsp에서 목록리스트 데이터 저장
				request.setAttribute("list", boardList.getList());
				// page.jsp에서 페이징 처리 데이터 저장
				dis.forward(request, response);
			} catch (SQLException e) {	
				e.printStackTrace();
			}	
		} //게시판 전체 출력(페이징)
		 
		 /*
		else if(command.equals("/boardList.bo")) { //게시판 전체 출력
			try {
				boardList = boardDAO.boardList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
				request.setAttribute("boardList",boardList);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}//게시판 전체출력
		*/
		 
		else if(command.equals("/boardDelete.bo")) { //게시판 글 삭제
			String no1 = request.getParameter("no");
			int no = Integer.parseInt(no1);
			try {
				cnt = boardDAO.boardDelete(no);
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//게시판 글 삭제
		
		else if(command.equals("/boardSearch.bo")) { //게시판 글 검색
			try {
				String searchTitle = request.getParameter("searchTitle");
				String readcount = request.getParameter("readcount");
				boardDTO = boardDAO.boardSearch(searchTitle);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardSearch");
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //게시판 글 검색
		 
		else if(command.equals("/boardUpdateSearch.bo")) {//게시판 글 수정
			updateTitle = request.getParameter("updateTitle");
			System.out.println(updateTitle);
			try {
				boardDTO = boardDAO.boardSearch(updateTitle);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardUpdateConfirm");
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //게시판 글 수정
		
		else if(command.equals("/boardUpdate.bo")) {//게시판 글 수정
			boardDTO.setNo(Integer.parseInt(request.getParameter("no")));
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setAuthor(request.getParameter("author"));
			boardDTO.setNal(request.getParameter("nal"));
			boardDTO.setReadcount(Integer.parseInt(request.getParameter("readcount")));
			try {
				cnt = boardDAO.boardUpdate(boardDTO,updateTitle);
				boardList = boardDAO.boardList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
				request.setAttribute("boardList", boardList);
				dis.forward(request, response);
				
				//response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //게시판 글 수정
	}

}
