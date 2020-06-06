package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBall_with3Brule {
	
	public static int[] distinctR = new int[3];
	
	public static int checkStrikeCount(int[] random, int[] input) {
		int strike = 0;
		
		for (int i=0; i<3; i++) {
			if (input[i]==random[i]) {
				strike++;
			} 
		}
		return strike;
	}

	public static int checkBallCount(int[] random, int[] input) {
		int ball = 0;
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<i; j++) {
				if (distinctR[i]==distinctR[j]) {
					distinctR[j]= -1;
				}
			}
		}
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (distinctR[i] == -1) {
					continue;
				}
				
				if (j>0) {
					if (input[j]==input[j-1]) {
						continue;
					}
				}
				
				if (distinctR[i]==input[j]) {
					if (i!=j) {
						ball++;
					}
				}
			}
		}
		
		return ball;
	}
	
	public static void main(String[] args) {

		/*
		 * 야구 게임
		 * 1~9까지의 임의의 수 3개를 가진 배열이 있다.
		 * 사용자로부터 숫자 3개를 입력받아 순서대로 배열에 저장한다.
		 * 사용자가 입력한 숫자와 임의의 숫자들을 비교해서
		 * 숫자가 동일하고 인덱스도 동일하면 strike
		 * 숫자는 동일하지만 인덱스가 일치하지 않으면 ball로 판정한다.
		 * 		최대 10회까지 시도할 수 있다.
		 * 		출력값이 "3S0B"인 경우 사용자가 숫자를 모두 맞힌 경우다.
		 */
		int[] randomNumbers = new int[3];
		for (int i=0; i<3; i++) {
			int random = (int)(Math.random()*9)+1;
			randomNumbers[i] = random;
		}
		
		System.out.println("야구게임 시작");
		int[] inputNumbers = new int[3];
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(Arrays.toString(randomNumbers));
		int count=0;
		while(true) {
			for (int i=0; i<3; i++) {
				System.out.println("숫자를 입력하세요: ");
				inputNumbers[i] = scanner.nextInt();
			}
			
			for (int i=0; i<3; i++) {
				distinctR[i] = randomNumbers[i];
			}
			
			int strike = checkStrikeCount(randomNumbers, inputNumbers);
			int ball = checkBallCount(randomNumbers, inputNumbers);
			
			if(strike==3) {
				System.out.println("정답입니다!");
				break;
			} else {
				System.out.println(strike + "S" + ball + "B");
			}
			
			count++;
			System.out.println("현재 도전 횟수 : " + count);

			if (count==10) {
				System.out.println("제한 횟수를 모두 소진하셨습니다.");
				break;
			}
		}
		System.out.println("게임이 종료되었습니다.");
		
		scanner.close();
	}
}
