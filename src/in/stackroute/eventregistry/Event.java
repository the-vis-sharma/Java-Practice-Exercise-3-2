package in.stackroute.eventregistry;

public abstract class Event implements IEvent {

	/*
	 * This class will  have all the common properties and behaviors for events
	 */

	private int eventId;
	private String name;
	private String description;
	private String city;
	private double price;
	private String type;
	private int maxSeats;

	public Event() {

	}

	public Event(String name, String description, String city, double price, String type, int maxSeats) {
		this.eventId = new EventStore().listAllEvent().size() + 1;
		this.name = name;
		this.description = description;
		this.city = city;
		this.price = price;
		this.type = type;
		this.maxSeats = maxSeats;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public abstract void listAllBookings();

	@Override
	public String toString() {
		return String.format("%-10s\t %-30s\t %-20s\t %-20s\t %-20s", eventId, name, type, city, price);
	}
}
