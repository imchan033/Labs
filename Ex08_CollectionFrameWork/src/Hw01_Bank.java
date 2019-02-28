import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/*
 시나리오
은행은 계좌를 관리한다.
은행은 계좌를 등록한다.
은행은 계좌번호로 계좌를 찾을 수 있다.
은행은 계좌의 소유자명으로 계좌를 찾을 수 있다.
은행은 모든 계좌의 목록을 볼 수 있다.
계좌는 소유자명, 계좌번호, 잔고로 구성된다.
계좌는 입금,출금 기능과 잔고확인 기능이 있다.
계좌에서 잔액의 변화가 있을 때마다 입출금 명세에 기록된다.
입출금 명세는 거래일자, 거래시간, 입금/출금, 금액, 잔액으로 구성된다.
 */

class Bank{
	List<Account> accounts;     //계좌(0개이상)
	private int totalAccount;   //총계좌수
	 
	public Bank() {
		accounts = new ArrayList<Account>();
		this.totalAccount = 0;
	}

	//계좌생성
	public void addAccount(String accountNo,String name) {
		accounts.add(new Account(accountNo, name));
		this.totalAccount++;
	}
	
	//계좌 찾기(계좌번호)
	public Account getAccount(String accountNo) {
		Account find = null;
		for(int i=0; i<accounts.size() ;i++){
			if(accounts.get(i).getAccountNo().equals(accountNo)) {
				find = accounts.get(i);
			}
		}
		return find;
	}
	
	//계좌 찾기(소유자명으로)
	public ArrayList<Account> findAccounts(String name) {
		//Account[] find = null;
		ArrayList<Account> find = new ArrayList<Account>();
		for(int i=0 ; i<accounts.size() ; i++) {
			if(accounts.get(i).getName().equals(name)) {
				find.add(accounts.get(i));

			}
		}
		return find;
	}
	
	//계좌목록을 본다
	public ArrayList<Account> getAccounts() {
		return (ArrayList<Account>) accounts;
	}
	
	//총계좌수를 반환한다
	public int getTotalAccount() {
		return this.totalAccount;
	}

	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + ", totalAccount=" + totalAccount + "]";
	}
	
	
	
}
class Account{
	List<Transaction> transactions; //거래내역(0개이상)
	private String accountNo; //계좌번호
	private String name;	  //소유자명
	private long balance;	  //잔고
	
	public Account(String accountNo, String name) {
		transactions = new ArrayList<Transaction>();
		this.accountNo = accountNo;
		this.name = name;
		balance = 0;
	}
	
	public String getAccountNo() {
		return this.accountNo;
	}

	public String getName() {
		return this.name;
	}

	//입금한다
	public void deposit(long amount) {
		this.balance += amount;
		transactions.add(new Transaction("입금", amount, balance));
	}
	
	//출금한다.
	public void withdraw(long amount) {
		if(balance>amount) {
		this.balance -= amount;
		transactions.add(new Transaction("출금", amount, balance));
		}else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	//잔고를 확인한다.
	public long getBalance() {
		return this.balance;
	}
	
	//거래내역을 본다.
	public ArrayList<Transaction> getTransactions() {
		return (ArrayList<Transaction>) transactions;
		
	
	}

	@Override
	public String toString() {
		return "Account [transactions=" + transactions + ", accountNo=" + accountNo + ", name=" + name + ", balance="
				+ balance + "]";
	}
}
class Transaction{
	private String transactionDate; //거래일
	private String transactionTime; //거래시간
	private String kind;			//구분(입금 또는 출금)
	private long amount;			//거래금액
	private long balance;			//잔고
	
	public Transaction(String kind, long amount, long balance) {
		this.transactionDate = LocalDate.now().toString();
        this.transactionTime = LocalTime.now().toString();
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", transactionTime=" + transactionTime + ", kind="
				+ kind + ", amount=" + amount + ", balance=" + balance + "]";
	}
	
	
	
	
	
}
public class Hw01_Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		bank.addAccount("307124", "이힘찬");
		bank.addAccount("111111", "홍길동");
		bank.addAccount("222222", "김유신");
		System.out.println(bank.getAccount("111111").toString());
		System.out.println(bank.findAccounts("이힘찬").toString());
		
		Account ac = bank.getAccount("111111");
		
		System.out.println(ac.toString());
		
		bank.getAccount("111111").deposit(10000);
		
		System.out.println(bank.getAccount("111111").toString());
		
		bank.getAccount("111111").withdraw(5000);
		
		System.out.println(bank.getAccount("111111").toString());

		bank.getAccount("111111").withdraw(15000);
	}

}
