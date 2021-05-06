// 1.2.2 Creation of the CurrentAccount class
package components;

public class CurrentAccount extends Account {

	public CurrentAccount(String label, Client client) {
		super(label, client);
	}
	
	public CurrentAccount(String label, Client client, double balance) {
		super(label, client, balance);
	}
}
