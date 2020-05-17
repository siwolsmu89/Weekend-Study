package shape;

public abstract class Shape {
	private double area;
	private String name;

	public Shape() {
	}

	public Shape(String name) {
		setName(name);
	}
	
	public double getArea() {
		return area;
	}
	
	public String getName() {
		return name;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	abstract void calculationArea();
	
	public void print() {
		System.out.println(name + "의 면적은 " + area);
	}
}
