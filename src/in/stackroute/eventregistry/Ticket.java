package in.stackroute.eventregistry;

import java.time.LocalDateTime;

public abstract class Ticket implements ITicket {

	/*
	 * Parent class for all kinds of events tickets.
	 */

	String[] availablePaymentModes = {"Cash",
			"Card",
			"Wallet",
			"UPI"};

	protected String status;
	protected int id;
	protected String customerName;
	protected LocalDateTime dateTime;
	protected int seats;
	protected String paymentMode;
	protected double amount;

	public abstract boolean bookTicket(Event movie);
	
	public abstract void printTicket();
}
