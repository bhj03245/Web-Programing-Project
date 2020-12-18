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
		
		if(command.contentEquals("/studentRegister.do")) { //학생 등록
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
				out.print(cnt+"건 학생이 등록되었습니다.<br>");
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
		} //학생 등록
		
		else if(command.contentEquals("/studentList.do")) { //학생 전체 출력
			response.sendRedirect("student/studentList.jsp");
		} //학생 전체 출력
		
		else if(command.contentEquals("/studentDelete.do")) { //학생 삭제
			String deleteName = request.getParameter("name");
			try {
				cnt = studentDAO.studentDeleteSql(deleteName);
				out.print(cnt+"건 학생이 삭제되었습니다.");
				response.sendRedirect("student/studentList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} // 학생 삭제 
		
		else if(command.contentEquals("/studentSearch.do")) { //학생검색
			String searchName = request.getParameter("name");
			try {
				rs = studentDAO.studentSearchSql(searchName);
				out.print("<h1>학생검색결과<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>학번</th>");
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
		
		} //학생 검색
		
		else if(command.contentEquals("/studentUpdate.do")) { //학생수정
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
			
		} //학생 수정
		
		else if(command.contentEquals("/studentUpdateConfirm.do")) { //학생 수정 확인
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("번호: "+studentDTO.getNo()+"나이: "+studentDTO.getAge()+"이름: "+studentDTO.getName()+"학번: "+studentDTO.getHakbun()+"<br>");
			out.print("<h1>최종수정 하기 전 내용입니다.</h1>");
			out.print("<form action=studentUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=나이수정>나이수정</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=이름수정>이름수정</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=학번수정>학번수정</label>");
			out.print("<input type=number name = hakbun>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //학생 수정 확인
		
		else if(command.contentEquals("/studentUpdateFinal.do")) { //학생 최종 수정
			studentDTO.setName(request.getParameter("name"));
			studentDTO.setAge(request.getParameter("age"));
			studentDTO.setHakbun(request.getParameter("hakbun"));
			try {
				cnt = studentDAO.studentUpdateSql(updateName, studentDTO);
				out.print(cnt+"건 학생이 수정되었습니다.");
				response.sendRedirect("student/studentList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //학생 최종 수정
		
		else if(command.contentEquals("/professorRegister.do")) { //교수 등록
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
				out.print(cnt+"건 교수가 등록되었습니다.<br>");
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
		} //교수 등록
		
		else if(command.contentEquals("/professorList.do")) { //교수 전체 출력
			response.sendRedirect("professor/professorList.jsp");
		} //교수 전체 출력
		
		else if(command.contentEquals("/professorDelete.do")) { //교수 삭제
			String deleteName = request.getParameter("name");
			try {
				cnt = professorDAO.professorDeleteSql(deleteName);
				out.print(cnt+"건 교수가 삭제되었습니다.");
				response.sendRedirect("professor/professorList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} //교수 삭제
		
		else if(command.contentEquals("/professorSearch.do")) { //교수 검색
			String searchName = request.getParameter("name");
			try {
				rs = professorDAO.professorSearchSql(searchName);
				out.print("<h1>교수검색결과<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>과목</th>");
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
		} //교수 검색
		
		
		else if(command.contentEquals("/professorUpdate.do")) { //교수 수정
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
			
		} //교수 수정
		
		else if(command.contentEquals("/professorUpdateConfirm.do")) { //교수 수정 확인
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("번호: "+professorDTO.getNo()+"나이: "+professorDTO.getAge()+"이름: "+professorDTO.getName()+"과목: "+professorDTO.getSubject()+"<br>");
			out.print("<h1>최종수정 하기 전 내용입니다.</h1>");
			out.print("<form action=professorUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=나이수정>나이수정</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=이름수정>이름수정</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=과목수정>과목수정</label>");
			out.print("<input type=text name = subject>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //교수 수정 확인
		
		else if(command.contentEquals("/professorUpdateFinal.do")) { //교수 최종 수정
			professorDTO.setName(request.getParameter("name"));
			professorDTO.setAge(request.getParameter("age"));
			professorDTO.setSubject(request.getParameter("subject"));
			try {
				cnt = professorDAO.professorUpdateSql(updateName, professorDTO);
				out.print(cnt+"건 교수가 수정되었습니다.");
				response.sendRedirect("professor/professorList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //교수 최종 수정
		
		else if(command.contentEquals("/managerRegister.do")) { //관리자 등록
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
				out.print(cnt+"건 관리자가 등록되었습니다.<br>");
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
		} //관리자 등록
		
		else if(command.contentEquals("/managerList.do")) { //관리자 전체 출력
			response.sendRedirect("managers/managerList.jsp");
		} //관리자 전체 출력
		
		else if(command.contentEquals("/managerDelete.do")) { //관리자 삭제
			String deleteName = request.getParameter("name");
			try {
				cnt = managerDAO.managerDeleteSql(deleteName);
				out.print(cnt+"건 관리자가 삭제되었습니다.");
				response.sendRedirect("managers/managerList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} //관리자 삭제
		
		else if(command.contentEquals("/managerSearch.do")) { //관리자 검색
			String searchName = request.getParameter("name");
			try {
				rs = managerDAO.managerSearchSql(searchName);
				out.print("<h1>관리자검색결과<h1>");
				out.print("<table border=3 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>부서</th>");
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
		} //관리자 검색
		
		
		else if(command.contentEquals("/managerUpdate.do")) { //관리자 수정
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
			
		} //관리자 수정
		
		else if(command.contentEquals("/managerUpdateConfirm.do")) { //관리자 수정 확인
			out.print("<style>");
			out.print("ul{list-style-type: none;");
			out.print("</style>");
			out.print("번호: "+managerDTO.getNo()+"나이: "+managerDTO.getAge()+"이름: "+managerDTO.getName()+"부서: "+managerDTO.getPart()+"<br>");
			out.print("<h1>최종수정 하기 전 내용입니다.</h1>");
			out.print("<form action=managerUpdateFinal.do method=get>");
			out.print("<input type=hidden name=updateName value="+updateName+">");
			out.print("<ul>");
			out.print("<li><label for=나이수정>나이수정</label>");
			out.print("<input type=number name = age>");
			out.print("</li>");
			out.print("<li><label for=이름수정>이름수정</label>");
			out.print("<input type=text name = name>");
			out.print("</li>");
			out.print("<li><label for=부서수정>부서수정</label>");
			out.print("<input type=text name = part>");
			out.print("</li>");
			out.print("<li>");
			out.print("<input type=image src=images/update.png class=kh01>");
			out.print("</li>");
			out.print("</ul>");
			out.print("</form>");
		} //관리자 수정 확인
		
		else if(command.contentEquals("/managerUpdateFinal.do")) { //관리자 최종 수정
			managerDTO.setName(request.getParameter("name"));
			managerDTO.setAge(request.getParameter("age"));
			managerDTO.setPart(request.getParameter("part"));
			try {
				cnt = managerDAO.managerUpdateSql(updateName, managerDTO);
				out.print(cnt+"건 관리자가 수정되었습니다.");
				response.sendRedirect("managers/managerList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //관리자 최종 수정
	}

}
