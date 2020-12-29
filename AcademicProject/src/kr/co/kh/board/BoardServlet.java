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
		
		 if (command.equals("/boardRegister.bo")) { //�Խ��� ���
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
		} //�Խ��� ���
		
		else if(command.equals("/boardList.bo")) { //�Խ��� ��ü ���(����¡)
			try {
				int curPage = 1; //�⺻ ������
				if(request.getParameter("curPage")!=null) {
					curPage = Integer.parseInt(request.getParameter("curPage"));
				}
				PageTo boardList = boardDAO.pageTo(curPage);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/list");
				request.setAttribute("page", boardList);
				//listPage.jsp���� ��ϸ���Ʈ ������ ����
				request.setAttribute("list", boardList.getList());
				// page.jsp���� ����¡ ó�� ������ ����
				dis.forward(request, response);
			} catch (SQLException e) {	
				e.printStackTrace();
			}	
		} //�Խ��� ��ü ���(����¡)
		 
		 /*
		else if(command.equals("/boardList.bo")) { //�Խ��� ��ü ���
			try {
				boardList = boardDAO.boardList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
				request.setAttribute("boardList",boardList);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}//�Խ��� ��ü���
		*/
		 
		else if(command.equals("/boardDelete.bo")) { //�Խ��� �� ����
			String no1 = request.getParameter("no");
			int no = Integer.parseInt(no1);
			try {
				cnt = boardDAO.boardDelete(no);
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//�Խ��� �� ����
		
		else if(command.equals("/boardSearch.bo")) { //�Խ��� �� �˻�
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
		} //�Խ��� �� �˻�
		 
		else if(command.equals("/boardUpdateSearch.bo")) {//�Խ��� �� ����
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
		} //�Խ��� �� ����
		
		else if(command.equals("/boardUpdate.bo")) {//�Խ��� �� ����
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
		} //�Խ��� �� ����
	}

}
