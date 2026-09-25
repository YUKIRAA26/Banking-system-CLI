package Bank;

public class Transaction {
	private String type;
	private	double amount;
	private String dateTime;
	private String otherAccount;
	
	private double balance;

	
	public Transaction(String type, double amount,String dateTime,String otherAccount){
		this.setType(type);
		
		if(type.equalsIgnoreCase("DEPOSIT") || type.equalsIgnoreCase("TRANSFER IN")) {
			this.amount = amount;
		}else if(type.equalsIgnoreCase("WITHDRAW") || type.equalsIgnoreCase("TRANSFER OUT")) {
			this.amount = -amount;
		}
		this.dateTime = dateTime;
		this.setOtherAccount(otherAccount);
	}
	
	public Transaction(String type, double amount, String dateTime, String otherAccount, double balance) {
	    this.type = type;
	    this.amount = amount;       // already signed — don't recompute
	    this.dateTime = dateTime;
	    this.otherAccount = otherAccount;
	    this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(String otherAccount) {
		this.otherAccount = otherAccount;
	}
	
	public double getBalance() { return balance; }
	public void setBalance(double balance) { this.balance = balance; }


}
