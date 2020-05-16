package src.controlQuiz;

import java.util.Scanner;

public class passwordEscape {
	
	public static void main(String[] args) {
		// 비밀번호 맞추어 탈출하기 게임
		
		// 1. 1~100 사이의 임의의 정수를 한 개 생성해 저장한다.
		// 2. 1에서 생성한 정수와 사용자가 입력한 값을 비교해 up/down을 표시한다.
		// 3. 사용자가 입력한 값이 생성한 정수와 일치할 때까지 up/down을 반복한다.
		// 4. 두 값이 일치하면 몇 번의 시도 끝에 맞추었는지 출력하고 게임을 종료한다.

		int secretNumber =(int)(Math.random()*100+1);
		int inputCount;
		int inputNumber;
		int numMax, numMin;
		
		Scanner scanner = new Scanner(System.in);
		
		inputCount=0;
		numMax=100; numMin=1; 
		
		System.out.print("1~100 범위의 숫자를 하나 입력해주세요: ");
		inputNumber = scanner.nextInt();

		while (true) {
			inputCount++;
			if (inputNumber==secretNumber) {
				System.out.print("found! ");
				System.out.println("정답: "+secretNumber+" 시도한 횟수: "+inputCount);
				break;
			} else if (inputNumber<secretNumber) {
				System.out.print("up! 입력한 값: "+inputNumber);
				numMin = inputNumber;
				System.out.println(" 예상범위: "+numMin+"부터 "+numMax+"사이");
			} else {
				System.out.print("down! 입력한 값: "+inputNumber);
				numMax = inputNumber;
				System.out.println(" 예상범위: "+numMin+"부터 "+numMax+"사이");
			}
			inputNumber=(int)(Math.random()*(numMax-numMin)+numMin);
		}
		
	}
}
