package controlQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 두 개를 입력받아 그 두 숫자 사이의 모든 정수를 더하는 반복문 만들기
 * @author siwol_smu
 *
 */
public class control_1 {

	/**
	 * 키보드로부터 숫자를 입력받는 메소드
	 * @return int형 숫자
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private static int getNumber() throws NumberFormatException, IOException {
		int result = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		result = Integer.parseInt(reader.readLine());
		
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.print("첫 번째 숫자를 입력하세요: ");
		int firstNumber = getNumber();
		System.out.print("두 번째 숫자를 입력하세요: ");
		int secondNumber = getNumber();
		
		// 1. for문을 사용하여 두 수의 합을 구하시오. (구한 값은 println으로 출력)
		int sum = 0;
		for (int i = firstNumber; i<=secondNumber; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// 2. while문을 사용하여 두 수의 합을 구하시오. (구한 값은 println으로 출력)
		int n = firstNumber;
		sum = 0;
		while (n <= secondNumber) {
			sum += n;
			n++;
		}
		System.out.println(sum);
		
		// 3. (선택) 	그 밖에 생각해 본 다른 방법이 있다면 적어 보시오.
		if (firstNumber > secondNumber) {
			int tmp = firstNumber;
			firstNumber = secondNumber;
			secondNumber = tmp;
		}
		sum = 0;
		for (int i = firstNumber; i<=secondNumber; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
	
}
