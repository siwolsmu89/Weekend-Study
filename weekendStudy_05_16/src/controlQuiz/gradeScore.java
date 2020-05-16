package src.controlQuiz;

public class gradeScore {
	
	public static void main(String[] args) {
		/*
		 * 성적표 출력하기
		 * 		60점 이상힌 경우 합격, 그 외에는 불합격이다.
		 * 		단, 합격자 중에서 성적이 100점인 경우 전액 장학금을 지급한다.
		 * 					 성적이 96점 이상인 경우 반액 장학금을 지급한다.
		 * 		단, 성적이 40점 이하인 경우 다음 응시 기회를 박탈한다.
		 * 
		 * Scanner를 사용하여 성적을 입력받고, 입력받은 성적과 그 결과를 출력하는 기능을 만드시오.
		 * - 똑같은 기능을 if문으로 한 번, switch문으로 한 번 만드시오.
		 */

		int score = 10;
		if (score>=60) {
			System.out.println("합격입니다.");
			if (score==100) {
				System.out.println("전액 장학금이 지급됩니다.");
			} else if(score>=96) {
				System.out.println("반액 장학금이 지급됩니다.");
			}
		} else {
			System.out.println("불합격입니다.");
			if (score<=40) {
				System.out.println("다음 회차 응시 기회를 박탈합니다.");
			}
		}
		
	}
}
