package kr.co.kh.academic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class AcademicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDTO studentDTO;
	private StudentDAO studentDAO;
	private Connection conn;
	private ResultSet rs;
	private int cnt = 0;
	private String updateName = null;
	
	public AcademicServlet(){
		studentDTO = new StudentDTO();
		try {
			studentDAO = new StudentDAO();
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
		
		if(command.contentEquals("/studentRegister.do")) { //�л� ���
			String age = request.getParameter("age");
			String name = request.getParameter("name");
			String hakbun = request.getParameter("hakbun");
			studentDTO.setAge(age);
			studentDTO.setName(name);
			studentDTO.setHakbun(hakbun);
			try {
				conn = studentDAO.getConnection();
				studentDAO.studentRegisterSql(studentDTO);
				cnt = studentDAO.studentExecuter();
				out.print(cnt+"�� �л��� ��ϵǾ����ϴ�.<br>");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				response.sendRedirect("student/studentList.jsp");
			}
		} //�л� ���
		
		else if(command.contentEquals("/studentList.do")) { //�л� ��ü ���
			response.sendRedirect("student/studentList.jsp");
		} //�л� ��ü ���
		
		else if(command.contentEquals("/studentDelete.do")) { //�л� ����
			String deleteName = request.getParameter("name");
			try {
				cnt = studentDAO.studentDeleteSql(deleteName);
				out.print(cnt+"�� �л��� �����Ǿ����ϴ�.");
				response.sendRedirect("student/studentList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} // �л� ���� 
		
		else if(command.contentEquals("/studentSearch.do")) { //�л��˻�
			String searchName = request.getParameter("name");
			try {
				rs = studentDAO.studentSearchSql(searchName);
				out.print("<h1>�л��˻����<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>��ȣ</th> <th>����</th> <th>�̸�</th> <th>�й�</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");
					out.print("<td>"+rs.getString("hakbun")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		} //�л� �˻�
		
		else if(command.contentEquals("/studentUpdate.do")) { //�л�����
			updateName = request.getParameter("name");
			try {
				rs = studentDAO.studentSearchSql(updateName);
				while(rs.next()) {
					studentDTO.setNo(rs.getInt("no"));
					studentDTO.setAge(rs.getString("age"));
					studentDTO.setName(rs.getString("name"));
					studentDTO.setHakbun(rs.getString("hakbun"));
				}
				response.sendRedirect("studentUpdateConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		} //�л� ����
		
		else if(command.contentEquals("/studentUpdateConfirm.do")) { //�л� ���� ����
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("��ȣ: "+studentDTO.getNo()+"����: "+studentDTO.getAge()+"�̸�: "+studentDTO.getName()+"�й�: "+studentDTO.getHakbun()+"<br>");
			out.print("<h1>�������� �ϱ� �� �����Դϴ�.</h1>");
			out.print("<form action=studentUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=���̼���>���̼���</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=�̸�����>�̸�����</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=�й�����>�й�����</label>");
			out.print("<input type=number name = hakbun>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //�л� ����Ȯ��
		
		else if(command.contentEquals("/studentUpdateFinal.do")) { //�л� ���� ����
			studentDTO.setName(request.getParameter("name"));
			studentDTO.setAge(request.getParameter("age"));
			studentDTO.setHakbun(request.getParameter("hakbun"));
			try {
				cnt = studentDAO.studentUpdateSql(updateName, studentDTO);
				out.print(cnt+"�� �л��� �����Ǿ����ϴ�.");
				response.sendRedirect("student/studentList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //�л� ���� ����
		
	}

}
