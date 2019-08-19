package in.stackroute.eventregistry;

public abstract class Ticket implements ITicket {

	String[] availablePaymentModes = {"Cash",
			"Card",
			"Wallet",
			"UPI"};

	public abstract boolean bookTicket(Event movie);
	
	public abstract void printTicket();
}
