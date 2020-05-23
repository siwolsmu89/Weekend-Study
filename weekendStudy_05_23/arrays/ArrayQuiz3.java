package arrays;

import java.util.Scanner;

public class ArrayQuiz3 {
	public static void main(String[] args) {
		// 원본 : ArrayDemo6
		// 숫자를 6개 입력받고, 그 중에서 값이 짝수인 것들만 더해서 출력하기
		// ex) 1,3,4,6,7,9 입력 -> 4+6 = 10
		
		Scanner scanner = new Scanner(System.in);
		
		int numbers[] = new int[6];
		
		for (int i=0; i<6; i++) {
			numbers[i] = scanner.nextInt();
		}
		
		int sum = 0;
		for (int number : numbers) {
			if (number%2==0) {
				sum += number;
			}
		}
		
		System.out.println(sum);
		scanner.close();
	}
}
