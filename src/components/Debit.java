// 1.3.3 Creation of the Transfert, Credit, Debit classes
package components;

import java.time.LocalDate;

public class Debit extends Flow {

	public Debit(double amount, String accountID, LocalDate localDate) {
		super(amount, accountID, localDate);
	}

	public Debit(String comment, Double amount, String accountID, Boolean effect, LocalDate date) {
		super(comment, amount, accountID, effect, date);
	}

}
