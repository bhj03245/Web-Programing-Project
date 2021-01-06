package kr.co.kh.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
			String pw = request.getParameter("pw");
			String deletePw = (String)session.getAttribute("pw");
			String deleteId = (String)session.getAttribute("id");	
			if(pw.equals(deletePw)) {
				try {
					cnt = memberDAO.memberDelete(deleteId,deletePw);
					session.invalidate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				out.print("<script>alert('회원탈퇴 되었습니다.'); location.href='index.jsp';</script>");
			}
			else {
				out.print("<script>alert('비밀번호가 틀립니다.'); location.href='index.jsp';</script>");
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
	            session.setAttribute("pw", pw);
	            response.sendRedirect("index.jsp");
			}
		} //로그인
		
		else if(command.equals("/memberLogout.mb")) { //로그아웃
			session.invalidate();
			out.print("<script>alert('로그아웃 되었습니다.'); location.href='index.jsp';</script>"); 
		} //로그아웃
		
		else if(command.equals("/memberidCheck.mb")) { //아이디 찾기
			String tel = request.getParameter("tel");
			try {
				String id = memberDAO.memberidCheck(tel);
				out.print("<script>alert('찾으신 아이디는"+id+"입니다.'); location.href='index.jsp';</script>"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //아이디 찾기
		
		else if(command.equals("/memberpwCheck.mb")) { //패스워드 찾기
			String id = request.getParameter("id");
			try {
				String pw = memberDAO.memberpwCheck(id);
				out.print("<script>alert('찾으신 비밀번호는"+pw+"입니다.'); location.href='index.jsp';</script>"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //패스워드 찾기
		
		else if(command.equals("/memberUpdateConfirm.mb")) { //회원 수정
			String id = request.getParameter("id");
			String updateID = (String)session.getAttribute("id");	
			try {
				if(id.equals(updateID)) {
					memberDTO = memberDAO.memberUpdateConfirm(id);
					RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberUpdateConfirm");
					request.setAttribute("memberDTO", memberDTO);
					dis.forward(request, response);
				}
				else {
					out.print("<script>alert('로그인한 정보로만 수정이 가능합니다.'); location.href='memberList.mb';</script>");  
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //회원수정
		
		else if(command.equals("/memberUpdateFinal.mb")) { //회원 최종 수정
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setAddr(request.getParameter("addr"));
			memberDTO.setTel(request.getParameter("tel"));
			String updateID = request.getParameter("updateId");
			try {
				cnt = memberDAO.memberUpdateFinal(memberDTO,updateID);
				out.print("<script>alert('회원정보가 수정되었습니다.'); location.href='memberList.mb';</script>");  
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //회원 최종 수정
		
		else if(command.equals("/idcheck.mb")) { //ID중복찾기
			String searchID = request.getParameter("id");
			try {
				ResultSet rs = memberDAO.IDcheck(searchID);
				if(!rs.isBeforeFirst()){
					out.print("사용가능한 ID입니다.");
					out.print("<input type='button' value='종료' onclick='self.close()'>");
				}
				else{
					out.print("해당 ID는 이미 사용중입니다.");
					out.print("<input type='button' value='종료' onclick='self.close()'>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //ID중복 찾기
	}

}
