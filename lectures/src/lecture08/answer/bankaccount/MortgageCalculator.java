
public class MortgageCalculator {
	
	BankAccountSpecification bank_acount;
	
	public MortgageCalculator(BankAccountSpecification b) {
		bank_acount = b;
	}
	
	public void makeMortgagePayment(int amount) {
		if (bank_acount.withdraw(amount))
			System.out.println(amount + "원 지불 완료");
		else
			System.out.println("잔고 부족");
	}

}
