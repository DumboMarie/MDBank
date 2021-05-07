// 1.3.2 Creation of the Flow class
package components;

import java.time.LocalDate;


public abstract class Flow {
	private String comment;
	private String flowID;
	static int flowNB;
	private double amount;
	private String accountID;
	private boolean effect;
	private LocalDate date;
	
	
	public Flow(double amount, String accountID,LocalDate localDate) {
		this.comment = "";
		this.amount = amount;
		this.accountID = accountID;
		this.effect = true;
		this.date = localDate;
		
		flowNB++;
		flowID = String.valueOf(flowNB);
	}
	
	public Flow(String comment, double amount, String accountID,boolean effect,LocalDate date) {
		this.comment = comment;
		this.amount = amount;
		this.accountID = accountID;
		this.effect = effect;
		this.date = date;
		
		flowNB++;
		flowID = String.valueOf(flowNB);
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}

	public static void setFlowNB(int flowNB) {
		Flow.flowNB = flowNB;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public String getFlowID() {
		return flowID;
	}

	public static int getFlowNB() {
		return flowNB;
	}

	public double getAmount() {
		return amount;
	}

	public String getAccountID() {
		return accountID;
	}

	public boolean isEffect() {
		return effect;
	}

	public LocalDate getDate() {
		return date;
	}

}
