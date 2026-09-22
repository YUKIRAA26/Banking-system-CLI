package Bank;
import java.util.*;	

public class Main {
	private final static Scanner scanner = new Scanner(System.in);
	private final static AccountManager accountManager = new AccountManager();

	public static void main(String[] args) {
		Account isLogged = null;
		while(isLogged == null) {
			accountMenu();
			String choice = Exceptions.StringException("Enter choice: ");
			
			switch(choice) {
				case "1" -> accountManager.createAccount();
				case "2" -> isLogged = accountManager.loginAccount();
				case "3" -> {
					System.out.println("Thank you! ");
					return;
				}
				default -> System.out.println("Invalid input! ");
			}
			
	
			if(isLogged != null) {
				while(true) {
					bankDisplayMenu(isLogged.getAccountNumber());
					String choice1 = Exceptions.StringException("Enter choice: ");
					
					if(choice1.equals("5")) {
						System.out.println("LOGGED OUT! ");
						isLogged = null;
						break;
					}
					
					switch(choice1) {
						case "1" -> BankManager.deposit(isLogged.getAccountNumber());
						case "2" -> BankManager.withdraw(isLogged.getAccountNumber());
						case "3" -> BankManager.checkBalance(isLogged.getAccountNumber());
						case "4" -> BankManager.transfer(accountManager, isLogged.getAccountNumber());
					}
				}
			}
		}
			
	}
	
	private static void accountMenu() {
		System.out.println("===== BANK SYSTEM =====");
		System.out.println("1. Create Account");
		System.out.println("2. Login");
		System.out.println("3. Exit ");
	}
	
	private static void bankDisplayMenu(String number) {
		System.out.println("===== ACCOUNT =====");
		System.out.println("Welcome " + accountManager.infos().get(number).getName());
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		System.out.println("4. Transfer");
		System.out.println("5. Log out");
	}

}
