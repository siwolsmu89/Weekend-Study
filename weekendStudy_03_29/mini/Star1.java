package mini;

import java.util.Scanner;

public class Star1 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();

		for (int i=0; i<=(num/2); i++) {
			for(int j = 0 ; j<(i); j++){
				System.out.print(" ");
			} 			

			for (int j=0 ; j<(num-(i*2)); j++){
				System.out.print("*");
			}
			System.out.println();
		}

		scanner.close();
		
		
	}

}
