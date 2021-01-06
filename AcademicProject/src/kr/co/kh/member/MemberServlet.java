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
		
		if(command.equals("/memberRegister.mb")){ //ȸ�� ����
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
		}//ȸ�� ����
		
		else if(command.equals("/memberList.mb")) { //ȸ�� ���
			try {
				memberList = memberDAO.memberList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberList");
				request.setAttribute("memberList",memberList);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/memberDelete.mb")) { //ȸ�� Ż��
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
				out.print("<script>alert('ȸ��Ż�� �Ǿ����ϴ�.'); location.href='index.jsp';</script>");
			}
			else {
				out.print("<script>alert('��й�ȣ�� Ʋ���ϴ�.'); location.href='index.jsp';</script>");
			}
		} //ȸ�� Ż��
		
		else if(command.equals("/memberLogin.mb")) { //�α���
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			try {
				memberDTO = memberDAO.memberLogin(id, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (!(id.equals(memberDTO.getId()))) {
	            out.print("<script>alert('���̵� ��ġ���� �ʽ��ϴ�');history.back();</script>");
	        } 
			else if (!(pw.equals(memberDTO.getPw()))) {
	            out.print("<script>alert('�н����尡 Ʋ�Ƚ��ϴ�.');history.back();</script>");
	        } 
			else {
	            session = request.getSession();
	            session.setAttribute("id", id);
	            session.setAttribute("pw", pw);
	            response.sendRedirect("index.jsp");
			}
		} //�α���
		
		else if(command.equals("/memberLogout.mb")) { //�α׾ƿ�
			session.invalidate();
			out.print("<script>alert('�α׾ƿ� �Ǿ����ϴ�.'); location.href='index.jsp';</script>"); 
		} //�α׾ƿ�
		
		else if(command.equals("/memberidCheck.mb")) { //���̵� ã��
			String tel = request.getParameter("tel");
			try {
				String id = memberDAO.memberidCheck(tel);
				out.print("<script>alert('ã���� ���̵��"+id+"�Դϴ�.'); location.href='index.jsp';</script>"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //���̵� ã��
		
		else if(command.equals("/memberpwCheck.mb")) { //�н����� ã��
			String id = request.getParameter("id");
			try {
				String pw = memberDAO.memberpwCheck(id);
				out.print("<script>alert('ã���� ��й�ȣ��"+pw+"�Դϴ�.'); location.href='index.jsp';</script>"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //�н����� ã��
		
		else if(command.equals("/memberUpdateConfirm.mb")) { //ȸ�� ����
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
					out.print("<script>alert('�α����� �����θ� ������ �����մϴ�.'); location.href='memberList.mb';</script>");  
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //ȸ������
		
		else if(command.equals("/memberUpdateFinal.mb")) { //ȸ�� ���� ����
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setAddr(request.getParameter("addr"));
			memberDTO.setTel(request.getParameter("tel"));
			String updateID = request.getParameter("updateId");
			try {
				cnt = memberDAO.memberUpdateFinal(memberDTO,updateID);
				out.print("<script>alert('ȸ�������� �����Ǿ����ϴ�.'); location.href='memberList.mb';</script>");  
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //ȸ�� ���� ����
		
		else if(command.equals("/idcheck.mb")) { //ID�ߺ�ã��
			String searchID = request.getParameter("id");
			try {
				ResultSet rs = memberDAO.IDcheck(searchID);
				if(!rs.isBeforeFirst()){
					out.print("��밡���� ID�Դϴ�.");
					out.print("<input type='button' value='����' onclick='self.close()'>");
				}
				else{
					out.print("�ش� ID�� �̹� ������Դϴ�.");
					out.print("<input type='button' value='����' onclick='self.close()'>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //ID�ߺ� ã��
	}

}
