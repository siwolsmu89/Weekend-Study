package shape;

public class Circle extends Shape {
	private int radius;
	double pi = Math.PI;
	
	public Circle(){}
	
	public Circle(String name, int radius){
		super(name);
		setRadius(radius);
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void calculationArea() {
		double result = 0.0;
		
		result = radius*radius*pi;
		
		setArea(result); 
		
	}
}
