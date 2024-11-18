
public class BankAccount implements BankAccountSpecification {
	
	private int balance;
	
	public BankAccount(int amount) {
		balance = amount;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}

	public boolean withdraw(int amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		else
			return false;
	}
	
	public int getBalance() {
		return balance;
	}
}
