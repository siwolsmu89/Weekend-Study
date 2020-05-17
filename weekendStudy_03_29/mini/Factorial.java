package mini;

public class Factorial {
	public static void main(String[] args) {

		int n = 5;
		System.out.println(factorial(n));
	}

	public static int factorial(int n) {
		int result = 1;
		if (n == 1) {
			return n;
		}
		
		result = n*factorial(n-1);
		
		return result;
	}

}