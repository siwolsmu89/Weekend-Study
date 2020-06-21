package testExplain;

public class TestExp {

	public static void main(String[] args) {
	int a =3;
	int b=0;
	
	try {
		System.out.println(a/b);
	} catch(ArithmeticException e) {
		System.out.println("오류1");
	} catch(ArrayIndexOutOfBoundsException e) {
		
	} finally {
		System.out.println("마무리");
	}
	
	}
}
