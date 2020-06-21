package test;

import java.util.Scanner;

public class ArrayLength {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("배열의 길이를 입력하세요: ");
		int length = scanner.nextInt();
		
		int[] intArray = new int[length];
		
		for (int i =0; i<length; i++) {
			System.out.println("(" + i + ")번째 입력값을 넣으세요: ");
			intArray[i] = scanner.nextInt();
		}
		
		System.out.println("입력완료");
		
		for (int i = 0; i<length; i++) {
			System.out.print(intArray[i] + "\t");
		}
	}
	
}
