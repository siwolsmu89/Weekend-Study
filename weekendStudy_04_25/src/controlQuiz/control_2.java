package controlQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 정수 두 개를 입력받고, 조건에 따라 정해진 행동을 수행하는 제어문 연습
 * 제어문 : 조건문(if문, switch문 등)과 반복문(for문, while문 등)을 함께 지칭하는 말.
 * @author siwol_smu
 *
 */
public class control_2 {

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
		
		int sum = 0;
		
		// 입력받은 첫 번째 숫자가 두 번째 숫자보다 크다면 두 수의 합을 구하는 제어문을 작성하시오.
		
		// 입력받은 두 숫자의 크기 차이를 구하는 제어문을 작성하시오.
		
		// 입력받은 두 숫자의 크기 차이를 구하고, 결과가 항상 0 이상의 정수로 표현되도록 제어문을 작성하시오.
		
		// 두 숫자의 합이 홀수이면 그 결과를 그대로 출력하고, 두 숫자의 합이 짝수이면 결과가 홀수가 될 때까지 2로 나눈 수를 출력하시오.
			
	}
}
