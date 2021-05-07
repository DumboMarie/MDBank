// 1.3.3 Creation of the Transfert, Credit, Debit classes
package components;

import java.time.LocalDate;


public class Transfert extends Flow {
	public String transfertAccountID;
	
	public Transfert(double amount, String accountID, String transfertAccountID, LocalDate date) {
		super(amount, accountID, date);
		this.transfertAccountID = transfertAccountID;
	}

	public Transfert(String comment, double amount, String accountID, String transfertAccountID, boolean effect, LocalDate date) {
		super(comment, amount, accountID, effect, date);
		this.transfertAccountID = transfertAccountID;
	}
}
