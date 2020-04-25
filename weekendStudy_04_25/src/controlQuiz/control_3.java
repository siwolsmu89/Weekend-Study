package controlQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자를 입력받아 해당 숫자에 대한 구구단을 출력하기 
 *  예) 2 입력 시, 2*1부터 2*9까지 (구구단 2단)을 출력
 * @author siwol_smu
 *
 */
public class control_3 {
	
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
		System.out.print("숫자를 입력하세요: ");
		int dan = getNumber();
		
		// 해당 숫자에 대한 구구단 출력하기
		for (int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
		
		// 두 숫자를 입력받아 firstNumber 단부터 secondNumber 단까지의 구구단을 출력하기
		System.out.print("숫자를 입력하세요: ");
		int firstNumber = getNumber();
		System.out.print("숫자를 입력하세요: ");
		int secondNumber = getNumber();
		
		
	}
	
}
