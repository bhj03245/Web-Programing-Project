package kr.co.kh.academic;

import java.io.Serializable;

public class ProfessorDTO extends AcademicDTO implements Serializable,IProfessorDTO {
	private String subject;
	
	public ProfessorDTO() {
		super();
	}
	public ProfessorDTO(int no, String age, String name, String subject) {
		super(no, age, name);
		this.subject = subject;
	}
	
	@Override
	public String getSubject() {
		return subject;
	}
	
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return super.toString() + "ProfessorDTO [subject=" +subject+ "]";
	}

}
