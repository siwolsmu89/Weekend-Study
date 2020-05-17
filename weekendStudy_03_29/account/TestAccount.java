package account;

public class TestAccount {
	public static void main(String[] args) {
		String accNo = null;
		int balance = 0;
		
		Account accObj = new Account("073-3762-293");
		accNo = accObj.getAccNo();
		balance = accObj.getBalance();
		System.out.println(accNo+" 계좌의 잔고는 "+balance+"원입니다.");
		
		accObj.save(100);
		balance = accObj.getBalance();
		System.out.println(accNo+" 계좌의 잔고는 "+balance+"만원입니다.");
		
		accObj.deposit(30);
		balance = accObj.getBalance();
		System.out.println(accNo+" 계좌의 잔고는 "+balance+"만원입니다.");
	}

	


}


