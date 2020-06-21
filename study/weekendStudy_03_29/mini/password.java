package mini;

import java.util.Arrays;

public class password {

	public static void main(String[] args) {
		
		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";
		
		char[] source = sourceString.toCharArray();
		
		//프로그램을 구현부 시작
		// 참고 : 문자'a'의 정수값은 97이며, 'z'는 122입니다.
		// char c = 'a';
		// int i = (int) c;
		// char c1 = (char)i;
		
		// 프로그램 구현부 끝
		int num=0;
		char[] alphabet = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
		for (int i=0; i<source.length; i++) {
			for(int j = 0; j<alphabet.length; j++) {
				if(source[i]==alphabet[j]) {
					if(j>=24) {
						num = j-26;
					} else if (j==0){
						num = -3;
					}else {
						num = j;
					}
				}
			}
			source[i] = alphabet[num+3];
		}
		
		encodedString = String.valueOf(source);
		
		System.out.println("암호화할 문자열: " + sourceString);
		System.out.println("암호화된 문자열: "+ encodedString);
	}
}
