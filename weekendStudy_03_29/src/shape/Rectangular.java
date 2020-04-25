package shape;

public class Rectangular extends Shape {
	private double width;
	private double height;
	
	public Rectangular() {
	}
	
	public Rectangular(String name, double width, double height) {
		super(name);
		setWidth(width);
		setHeight(height);
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	void calculationArea() {
		double result =0.0;
		
		result = width*height;
		
		setArea(result);
	}
}
