package kr.co.kh.academic;

import java.io.Serializable;

public class StudentDTO implements Serializable {
	private int no;
	private String age; 
	private String name;
	private String hakbun;
	
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(int no, String age, String name, String hakbun) {
		super();
		this.no = no;
		this.age = age;
		this.name = name;
		this.hakbun = hakbun;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", age=" + age + ", name=" + name + ", hakbun=" + hakbun + "]";
	}
	
}
