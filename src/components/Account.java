// 1.2.1 Creation of the account class
package components;

import java.time.LocalDate;

public abstract class Account {

	protected String label;
	protected double balance;
	protected String accountID;
	static int accountNB;
	protected Client client;
	
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		this.balance = 0;
		accountNB++;
		accountID = String.valueOf(accountNB);
	}
	
	public Account(String label, Client client, double balance) {
		this.label = label;
		this.client = client;
		this.balance = balance;
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

	public void setBalance(Flow flow) {
		switch (flow.getClass().getSimpleName()) {
		case "Credit":
			this.balance += flow.getAmount();
			break;
		case "Debit":
			this.balance -= flow.getAmount();
			break;
		case "Transfert":
			this.balance += flow.getAmount();
			setBalance(new Debit(flow.getAmount(), ((Transfert) flow).transfertAccountID, flow.getDate()));
			break;
		default:
			break;
		}
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
	        return String.format("%s account n°%s %nowner : %s %s %nbalance : %s", 
	        		label,accountID, client.getName(), client.getFirstName(), balance);
	    }
	
	
}
