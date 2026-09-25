package Bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankManager {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private static String getCurrentDateTime() {
		return LocalDateTime.now().format(formatter);
	}

	public static void deposit(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== DEPOSIT =====");
		double amount = Exceptions.DoubleException("Enter amount: ");

		info.setBalance(info.getBalance() + amount);
		System.out.println("Succesfullt deposited " + "$" + amount);
		Transaction tx = new Transaction("DEPOSIT", amount, getCurrentDateTime(), null);
		tx.setBalance(info.getBalance());
		info.addTransaction(tx);
		SaveTransaction.saveFile(info, tx);
	}

	public static void withdraw(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== WITHDRAW =====");
		double amount = Exceptions.DoubleException("Enter amount: ");

		if (amount > info.getBalance()) {
			System.out.println("Not enough balance! ");
			return;
		}

		info.setBalance(info.getBalance() - amount);
		System.out.println("Succesfullt Withdraw " + "$" + amount);
		System.out.println("Remaining balance: " + info.getBalance());
		
		Transaction tx = new Transaction("withdraw", amount, getCurrentDateTime(), null);
		tx.setBalance(info.getBalance());
		info.addTransaction(tx);
		SaveTransaction.saveFile(info, tx);
	}

	public static void checkBalance(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== BALANCE =====");
		System.out.println("Balance: " + info.getBalance());
	}

	public static void transfer(String number) {
		Account info = AccountManager.infos().get(number);
		System.out.println("===== TRANSFER =====");
		String num = Exceptions.StringException("Enter number: ");
		Account receiver = AccountManager.infos().get(num);
		if (!AccountManager.infos().containsKey(num)) {
			System.out.println("Invalid number! ");
			return;
		}

		if (number.equalsIgnoreCase(num)) {
			System.out.println("Cannot transfer to own number! ");
			return;
		}

		double amount = Exceptions.DoubleException("Enter amount: ");

		if (info.getBalance() < amount) {
			System.out.println("Not enough balance! ");
			return;
		}
		receiver.setBalance(receiver.getBalance() + amount);
		info.setBalance(info.getBalance() - amount);
		System.out.println("Succesfully transfered " + "$" + amount + " to " + "[" + num + "]");
		Transaction senderTx = new Transaction("TRANSFER OUT", amount, getCurrentDateTime(),
				receiver.getAccountNumber());

		Transaction receiverTx = new Transaction("TRANSFER IN", amount, getCurrentDateTime(), info.getAccountNumber());
		receiverTx.setBalance(receiver.getBalance());
		receiver.addTransaction(receiverTx);
		senderTx.setBalance(info.getBalance());
		info.addTransaction(senderTx);
		SaveTransaction.saveFile(info, senderTx);
		SaveTransaction.saveFile(receiver, receiverTx);

	}

	public static void transactionHistory(Account account) {
		if (account.getTransaction().size() == 0) {
			System.out.println("Transaction history is empty! ");
			return;
		}

		for (int i = 0; i < account.getTransaction().size(); i++) {
			Transaction transac = account.getTransaction().get(i);
			System.out.println(transac.getDateTime() + " | " + transac.getType() + " | " + transac.getAmount() + " | "
					+  "Balance: " + transac.getBalance());
		}
	}
}
