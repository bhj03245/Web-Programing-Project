package kr.co.kh.academic;

public class AcademicDTO {
	private int no;
	private String age;
	private String name;
	
	public AcademicDTO() {
		super();
	}
	
	public AcademicDTO(int no, String age, String name) {
		super();
		this.no = no;
		this.age = age;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
	
	@Override
	public String toString() {
		return "AcademicDTO [no=" + no + ", age=" + age + ", name=" + name + "]";
	}
}
