package arrays.answer;

import java.util.Scanner;

public class ArrayQuiz2 {
	public static void main(String[] args) {
		// 숫자를 5개 입력받아 그 중 가장 큰 값을 찾아내기
		// 원본 : ArrayDemo8
		
		// 숫자를 담을 배열 생성
		int[] inputNums = new int[5];
		
		// 5번 반복해서 숫자를 입력받고 배열에 담기
		Scanner scanner = new Scanner(System.in);
		
		for (int i=0; i<5; i++) {
			inputNums[i] = scanner.nextInt();
		}
		
		// 최대값 구하기
		int max = 0;
		for (int number : inputNums) {
			if (number >= max) {
				max = number;
			}
		}
		
		System.out.println(max);
		scanner.close();
	}
}
