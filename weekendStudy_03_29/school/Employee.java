package school;

public class Employee {
	private String name;
	private int age;
	private String dept;

	Employee() {
	}

	Employee(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void print() {
		System.out.print("이름: "+name+"\t");
		System.out.print("나이: "+age+" \t");
		System.out.println("  부     서: "+dept);
	}
}
