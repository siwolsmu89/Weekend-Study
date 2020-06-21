package account;

public class Account {
	private String accNo = "";
	private int balance;
	
	Account(){}
	
	public Account(String accNo){
		this.accNo = accNo;
		balance = 0;
		System.out.println(accNo+" 계좌가 개설되었습니다.");
	}
	
	public String getAccNo(){
		return accNo;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void save(int money) {
		balance += money;
		System.out.println(accNo+" 계좌에 "+money+"만원이 입금되었습니다.");
	}
	
	public void deposit(int money) {
		balance -= money;
		System.out.println(accNo+" 계좌에서 "+money+"만원이 출금되었습니다.");
	}
	
	
	
}
