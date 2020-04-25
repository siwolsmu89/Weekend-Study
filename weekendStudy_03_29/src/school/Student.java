package school;

public class Student {
	private String name;
	private int age;
	private int studentNo;

	Student() {
	}

	Student(String name, int age, int studentNo) {
		this.name = name;
		this.age = age;
		this.studentNo = studentNo;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int studentNo() {
		return studentNo;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	
	public void print() {
		System.out.print("이름: "+name+"\t");
		System.out.print("나이: "+age+" \t");
		System.out.println("  학     번: "+studentNo);
	}

}
