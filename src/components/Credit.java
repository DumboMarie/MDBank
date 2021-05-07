// 1.3.3 Creation of the Transfert, Credit, Debit classes
package components;

import java.time.LocalDate;

public class Credit extends Flow {

	public Credit(double amount, String accountID, LocalDate localDate) {
		super(amount, accountID, localDate);
	}

	public Credit(String comment, double amount, String accountID, boolean effect, LocalDate date) {
		super(comment, amount, accountID, effect, date);
	}

}
