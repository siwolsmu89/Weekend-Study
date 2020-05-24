package arrays.answer;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz1 {
	public static void main(String[] args) {
		// 원본 : ArrayDemo7

		// 숫자를 5번 입력받아서 입력받은 숫자의 총합을 계산하기
		// 입력받은 숫자를 저장할 배열 : inputNumbers
		// 숫자의 총합 : sum
		int[] inputNumbers = new int[5];
		int sum = 0;
		
		// 키보드 입력받기
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<5; i++) {
			inputNumbers[i] = scanner.nextInt();
		}
		
		// 숫자 5번 입력받기
			// 입력받은 숫자를 변수에 저장하기
			// 변수에 저장된 값을 배열에 담기
		
		// 입력받은 숫자들의 총합을 계산해 출력하기
		for (int number : inputNumbers) {
			sum += number;
		}
		
		System.out.println(sum);
		scanner.close();
	}
}
