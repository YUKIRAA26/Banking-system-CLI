package Bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SaveTransaction {
	
	
	public static void saveFile(Account account, Transaction transaction) {
		File directory = new File("transaction");
		directory.mkdirs();
		
		File file = new File(directory, account.getAccountNumber() + ".txt");
		try(BufferedWriter write = new BufferedWriter(new FileWriter(file, true))){
			String amount = String.format("%+.2f", transaction.getAmount());
			String accountInfo = "";

			if(transaction.getType().equalsIgnoreCase("TRANSFER OUT")) {
			    accountInfo = "To: " + transaction.getOtherAccount();
			} else if(transaction.getType().equalsIgnoreCase("TRANSFER IN")) {
			    accountInfo = "From: " + transaction.getOtherAccount();
			}
	
			write.write(transaction.getDateTime() + "|" + transaction.getType() + "|" +  amount + "|" + accountInfo + "|" + "Balance: " + transaction.getBalance());
			write.newLine();
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void loadTransaction(Account account) {
		
		File file = new File("transaction/" + account.getAccountNumber() + ".txt");
		if (!file.exists()) {
			return;
		}
		
		try(BufferedReader reader = new BufferedReader(new FileReader("transaction/" + account.getAccountNumber() + ".txt"))) {
			String line;
			
			
			
			while((line = reader.readLine()) != null ) {
				String[] parts = line.split("\\|");
				String type = parts[1].trim();
				String rawAmount = parts[2].trim().replace("+", "");
				double amount = Double.parseDouble(rawAmount);
				String dateTime = parts[0].trim();
				String accountInfo = parts[3].trim();
				double balance = Double.parseDouble(parts[4].trim().replace("Balance: ", ""));
				
				account.addTransaction(new Transaction(type,amount,dateTime, accountInfo,balance));
			}
			
		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
