package controlQuiz;

import java.util.Scanner;

public class digitSum {

	public static void main(String[] args) {
		
		// 10000부터 99999 사이의 숫자를 입력한다.
		// 입력한 숫자의 각 자리 숫자를 모두 더한 값을 출력한다.
		// 예 : 12345 입력 -> 15 출력(1+2+3+4+5=15이므로)
		// 입력받는 숫자의 범위를 제한하는 기능은 생략한다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("임의의 5자리 숫자를 입력하세요(10000~99999): ");
		int inputNumber = scanner.nextInt();
		
		int lastNumber=0, sum=0;
		while(inputNumber!=0) {
			lastNumber = inputNumber%10;
			sum += lastNumber;
			inputNumber /= 10;
		}
		System.out.println("합계: "+sum);
		
	}
}
