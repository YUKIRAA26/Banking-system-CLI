package Bank;

import java.util.Map;

public class BankManager {
	public static void deposit(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== DEPOSIT =====");
		double amount = Exceptions.DoubleException("Enter amount: ");
		
		info.setBalance(info.getBalance() + amount);
		System.out.println("Succesfullt deposited " + "$" + amount);
	}
	
	public static void withdraw(String number) {
		Account info = AccountManager.infos().get(number);		
		System.out.println("===== WITHDRAW =====");
		double amount = Exceptions.DoubleException("Enter amount: ");
		
		if(amount > info.getBalance()) {
			System.out.println("Not enough balance! ");
			return;
		}
		
		info.setBalance(info.getBalance() - amount);
		System.out.println("Succesfullt Withdraw " + "$" + amount);
		System.out.println("Remaining balance: " + info.getBalance());
	}
	
	public static void checkBalance(String number) {
		Account info = AccountManager.infos().get(number);	
		System.out.println("===== BALANCE =====");
		System.out.println("Balance: " + info.getBalance());
	}
	
	public static void transfer(AccountManager infos, String number) {
		Account info = infos.infos().get(number);
		System.out.println("===== TRANSFER =====");
		String num = Exceptions.StringException("Enter number: ");
		if(!infos.infos().containsKey(num)) {
			System.out.println("Invalid number! ");
			return;
		}
		
		if(number.equalsIgnoreCase(num)) {
			System.out.println("Cannot transfer to own number! ");
			return;
		}
		
		double amount = Exceptions.DoubleException("Enter amount: ");
		infos.infos().get(num).setBalance(infos.infos().get(num).getBalance() + amount);
		infos.infos().get(number).setBalance(infos.infos().get(number).getBalance() - amount);
		System.out.println("Succesfully transfered " + "$" + amount + " to " + "["+ num + "]");
		
	}
}
