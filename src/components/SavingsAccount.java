// 1.2.2 Creation of the SavingsAccount class
package components;

public class SavingsAccount extends Account {

	public SavingsAccount(String label, Client client) {
		super(label, client);
	}
	
	public SavingsAccount(String label, Client client, double balance) {
		super(label, client, balance);
	}

}
