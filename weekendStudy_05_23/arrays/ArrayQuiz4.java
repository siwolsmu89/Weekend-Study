package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz4 {
	public static void main(String[] args) {
		/*
		 * 원본 : ArrayDemo11
		 * 
		 * 숫자 5개를 입력받아서 배열에 저장한다.
		 * 배열의 n번째까지의 합계를 새로운 배열에 저장하고, 새 배열의 값을 전부 출력한다.
		 * 예) [3, 5, 11, 7, 4] ===> [3, 8, 19, 26, 30]
		 */
		Scanner scanner = new Scanner(System.in);
		
		int[] inputNumbers = new int[5];
		
		for(int i=0; i<5; i++) {
			inputNumbers[i] = scanner.nextInt();
		}
		
		int[] calcedNumbers = new int[5];
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<=i; j++) {
				calcedNumbers[i] += inputNumbers[j];
			}
		}
		
		System.out.println(Arrays.toString(calcedNumbers));
		
		scanner.close();
	}
}
