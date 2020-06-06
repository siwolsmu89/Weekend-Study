package test001;

public class NoDuplicate {
	public static void main(String[] args) {
		int[] randoms = new int[3];
		
		for (int i = 0; i<3; i++) {
			int random = (int) (Math.random()*9 + 1);
			
			randoms[i] = random;
			for (int j = 0; j<i; j++) {
				if (randoms[j]==randoms[i]) {
					i--;
					System.out.println("["+(j+1)+"]번째 숫자와 중복이 발생해 숫자를 다시 뽑습니다.");
				}
			}
			
		}
		System.out.println(randoms[0]);
		System.out.println(randoms[1]);
		System.out.println(randoms[2]);
	}
}
