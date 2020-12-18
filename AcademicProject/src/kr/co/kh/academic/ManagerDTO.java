package kr.co.kh.academic;

import java.io.Serializable;

public class ManagerDTO extends AcademicDTO implements Serializable,IManagerDTO{
	private String part;
	
	public ManagerDTO() {
		super();
	
	}
	public ManagerDTO(int no, String age, String name, String part) {
		super(no, age, name);
		this.part = part;
	}
	
	@Override
	public String getPart() {
		return part;
	}
	
	@Override
	public void setPart(String part) {
		this.part = part;
	}

	@Override
	public String toString() {
		return super.toString() + "ManagerDTO [part=" +part+ "]";
	}
	

	
}
