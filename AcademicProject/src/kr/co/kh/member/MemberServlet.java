package kr.co.kh.member;

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
import javax.servlet.http.HttpSession;


@WebServlet("*.mb")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDTO memberDTO;
	private MemberDAO memberDAO;
	private ArrayList<MemberDTO> memberList;
	private int cnt;
	private HttpSession session;
	
	public MemberServlet() {
		memberDTO = new MemberDTO();
		memberDAO = new MemberDAO();
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
		
		if(command.equals("/memberRegister.mb")){ //회원 가입
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setAddr(request.getParameter("addr"));
			memberDTO.setTel(request.getParameter("tel"));
			try {
				cnt = memberDAO.memberRegister(memberDTO);
				response.sendRedirect("memberList.mb");
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}//회원 가입
		
		else if(command.equals("/memberList.mb")) { //회원 목록
			try {
				memberList = memberDAO.memberList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberList");
				request.setAttribute("memberList",memberList);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/memberDelete.mb")) { //회원 탈퇴
			String deleteID = request.getParameter("id");
			try {
				cnt = memberDAO.memberDelete(deleteID);
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberList");
				dis.forward(request,response);
						
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} //회원 탈퇴
		
		else if(command.equals("/memberLogin.mb")) { //로그인
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			try {
				memberDTO = memberDAO.memberLogin(id, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (!(id.equals(memberDTO.getId()))) {
	            out.print("<script>alert('아이디가 일치하지 않습니다');history.back();</script>");
	        } 
			else if (!(pw.equals(memberDTO.getPw()))) {
	            out.print("<script>alert('패스워드가 틀렸습니다.');history.back();</script>");
	        } 
			else {
	            session = request.getSession();
	            session.setAttribute("id", id);
	            response.sendRedirect("index.jsp");
			}
		} //로그인
		
		else if(command.equals("/memberLogout.mb")) { //로그아웃
			session.invalidate();
			out.print("<script>alert('로그아웃 되었습니다.'); location.href='index.jsp';</script>"); 
		} //로그아웃
		
		else if(command.equals("/")) {
			
		}
		
		else if(command.equals("/")) {
			
		}
	}

}
