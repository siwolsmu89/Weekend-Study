package src.controlQuiz;

import java.util.Scanner;

public class DiceEscape {

	public static void main(String[] args) {
		
		// 내가 입력한 주사위 숫자와 동일한 숫자가 나오면 탈출하는 주사위 게임 만들기
		
		// 규칙 1 : scanner를 만들어 숫자를 입력받고, 랜덤 함수를 사용하여 1~6 사이의 숫자를 랜덤으로 생성한다.
		// 		  입력받은 숫자와 랜덤 함수를 사용해 생성된 숫자가 일치하면 '탈출 성공'을 출력하고 반복문을 탈출한다.
		// 규칙 2 : 기회는 3번만 제공된다. 3번 안에 탈출에 성공하지 못하면 "탈출 실패"를 출력한다.
		// 규칙 3 : 탈출에 성공하건 실패하건 관계없이 '내가 입력한 숫자 : (입력한 숫자), 주사위 숫자 : (랜덤함수로 생성된 숫자)'를 결과로 출력한다.
		
		// 랜덤으로 1~6의 숫자를 생성하는 주사위는 아래의 randomDice을 사용한다.
		Scanner scanner = new Scanner(System.in);
		
		for (int i=1 ; i <= 3 ; i++) {
			System.out.print("주사위 숫자를 입력하세요(1~6): ");
			int diceInput = scanner.nextInt();
			int diceRandom = (int) (Math.random()*6 + 1);

			System.out.println("내가 입력한 주사위: ["+diceInput+"], 굴려서 나온 주사위: ["+diceRandom+"]");
			
			if (diceInput == diceRandom) {
				System.out.println("탈출 성공: ["+diceInput+"]");
				break;
			}
			if (i == 3 && diceInput != diceRandom) {
			System.out.println("탈출 실패");
			}
		}
	}
}
