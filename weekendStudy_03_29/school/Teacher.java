package school;

public class Teacher {
	private String name;
	private int age;
	private String subject;

	Teacher() {
	}

	Teacher(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void print() {
		System.out.print("이름: "+name+"\t");
		System.out.print("나이: "+age+" \t");
		System.out.println("  담당과목: "+subject);
	}
}
