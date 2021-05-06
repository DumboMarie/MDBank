// 1.2.1 Creation of the account class
package components;

public abstract class Account {

	protected String label;
	protected double balance;
	protected String accountID;
	static int accountNB;
	protected Client client;
	
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		accountNB++;
		accountID = String.valueOf(accountNB);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		this.balance = balance;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public static int getAccountNB() {
		return accountNB;
	}

	public static void setAccountNB(int accountNB) {
		Account.accountNB = accountNB;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	 @Override
	    public String toString() {
	        return String.format("Account n°%s %nowner : %s %s %n %s : balance : %s", 
	        		accountID, client.getName(), client.getFirstName(), label, balance);
	    }
	
	
}
