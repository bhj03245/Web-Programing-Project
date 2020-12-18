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
	private ProfessorDTO professorDTO;
	private ProfessorDAO professorDAO;
	private ManagerDTO managerDTO;
	private ManagerDAO managerDAO;
	private Connection conn;
	private ResultSet rs;
	private int cnt = 0;
	private String updateName = null;
	
	public AcademicServlet(){
		studentDTO = new StudentDTO();
		professorDTO = new ProfessorDTO();
		managerDTO = new ManagerDTO();
		try {
			studentDAO = new StudentDAO();
			professorDAO = new ProfessorDAO();
			managerDAO = new ManagerDAO();
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
		
		else if(command.contentEquals("/studentUpdateConfirm.do")) { //�л� ���� Ȯ��
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
		} //�л� ���� Ȯ��
		
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
		
		else if(command.contentEquals("/professorRegister.do")) { //���� ���
			String age = request.getParameter("age");
			String name = request.getParameter("name");
			String subject = request.getParameter("subject");
			professorDTO.setAge(age);
			professorDTO.setName(name);
			professorDTO.setSubject(subject);
			try {
				conn = professorDAO.getConnection();
				professorDAO.professorRegisterSql(professorDTO);
				cnt = professorDAO.professorExecuter();
				out.print(cnt+"�� ������ ��ϵǾ����ϴ�.<br>");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				response.sendRedirect("professor/professorList.jsp");
			}
		} //���� ���
		
		else if(command.contentEquals("/professorList.do")) { //���� ��ü ���
			response.sendRedirect("professor/professorList.jsp");
		} //���� ��ü ���
		
		else if(command.contentEquals("/professorDelete.do")) { //���� ����
			String deleteName = request.getParameter("name");
			try {
				cnt = professorDAO.professorDeleteSql(deleteName);
				out.print(cnt+"�� ������ �����Ǿ����ϴ�.");
				response.sendRedirect("professor/professorList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} //���� ����
		
		else if(command.contentEquals("/professorSearch.do")) { //���� �˻�
			String searchName = request.getParameter("name");
			try {
				rs = professorDAO.professorSearchSql(searchName);
				out.print("<h1>�����˻����<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>��ȣ</th> <th>����</th> <th>�̸�</th> <th>����</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");
					out.print("<td>"+rs.getString("subject")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //���� �˻�
		
		
		else if(command.contentEquals("/professorUpdate.do")) { //���� ����
			updateName = request.getParameter("name");
			try {
				rs = professorDAO.professorSearchSql(updateName);
				while(rs.next()) {
					professorDTO.setNo(rs.getInt("no"));
					professorDTO.setAge(rs.getString("age"));
					professorDTO.setName(rs.getString("name"));
					professorDTO.setSubject(rs.getString("subject"));
				}
				response.sendRedirect("professorUpdateConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		} //���� ����
		
		else if(command.contentEquals("/professorUpdateConfirm.do")) { //���� ���� Ȯ��
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("��ȣ: "+professorDTO.getNo()+"����: "+professorDTO.getAge()+"�̸�: "+professorDTO.getName()+"����: "+professorDTO.getSubject()+"<br>");
			out.print("<h1>�������� �ϱ� �� �����Դϴ�.</h1>");
			out.print("<form action=professorUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=���̼���>���̼���</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=�̸�����>�̸�����</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=�������>�������</label>");
			out.print("<input type=text name = subject>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //���� ���� Ȯ��
		
		else if(command.contentEquals("/professorUpdateFinal.do")) { //���� ���� ����
			professorDTO.setName(request.getParameter("name"));
			professorDTO.setAge(request.getParameter("age"));
			professorDTO.setSubject(request.getParameter("subject"));
			try {
				cnt = professorDAO.professorUpdateSql(updateName, professorDTO);
				out.print(cnt+"�� ������ �����Ǿ����ϴ�.");
				response.sendRedirect("professor/professorList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //���� ���� ����
		
		else if(command.contentEquals("/managerRegister.do")) { //������ ���
			String age = request.getParameter("age");
			String name = request.getParameter("name");
			String part = request.getParameter("part");
			managerDTO.setAge(age);
			managerDTO.setName(name);
			managerDTO.setPart(part);
			try {
				conn = managerDAO.getConnection();
				managerDAO.managerRegisterSql(managerDTO);
				cnt = managerDAO.managerExecuter();
				out.print(cnt+"�� �����ڰ� ��ϵǾ����ϴ�.<br>");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				response.sendRedirect("managers/managerList.jsp");
			}
		} //������ ���
		
		else if(command.contentEquals("/managerList.do")) { //������ ��ü ���
			response.sendRedirect("managers/managerList.jsp");
		} //������ ��ü ���
		
		else if(command.contentEquals("/managerDelete.do")) { //������ ����
			String deleteName = request.getParameter("name");
			try {
				cnt = managerDAO.managerDeleteSql(deleteName);
				out.print(cnt+"�� �����ڰ� �����Ǿ����ϴ�.");
				response.sendRedirect("managers/managerList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} //������ ����
		
		else if(command.contentEquals("/managerSearch.do")) { //������ �˻�
			String searchName = request.getParameter("name");
			try {
				rs = managerDAO.managerSearchSql(searchName);
				out.print("<h1>�����ڰ˻����<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>��ȣ</th> <th>����</th> <th>�̸�</th> <th>�μ�</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("name")+"</td>");
					out.print("<td>"+rs.getString("part")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //������ �˻�
		
		
		else if(command.contentEquals("/managerUpdate.do")) { //������ ����
			updateName = request.getParameter("name");
			try {
				rs = managerDAO.managerSearchSql(updateName);
				while(rs.next()) {
					managerDTO.setNo(rs.getInt("no"));
					managerDTO.setAge(rs.getString("age"));
					managerDTO.setName(rs.getString("name"));
					managerDTO.setPart(rs.getString("part"));
				}
				response.sendRedirect("managerUpdateConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		} //������ ����
		
		else if(command.contentEquals("/managerUpdateConfirm.do")) { //������ ���� Ȯ��
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("��ȣ: "+managerDTO.getNo()+"����: "+managerDTO.getAge()+"�̸�: "+managerDTO.getName()+"�μ�: "+managerDTO.getPart()+"<br>");
			out.print("<h1>�������� �ϱ� �� �����Դϴ�.</h1>");
			out.print("<form action=managerUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=���̼���>���̼���</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=�̸�����>�̸�����</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=�μ�����>�μ�����</label>");
			out.print("<input type=text name = part>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //������ ���� Ȯ��
		
		else if(command.contentEquals("/managerUpdateFinal.do")) { //������ ���� ����
			managerDTO.setName(request.getParameter("name"));
			managerDTO.setAge(request.getParameter("age"));
			managerDTO.setPart(request.getParameter("part"));
			try {
				cnt = managerDAO.managerUpdateSql(updateName, managerDTO);
				out.print(cnt+"�� �����ڰ� �����Ǿ����ϴ�.");
				response.sendRedirect("managers/managerList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //������ ���� ����
	}

}
