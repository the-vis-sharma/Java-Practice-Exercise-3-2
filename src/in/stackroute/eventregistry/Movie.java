package in.stackroute.eventregistry;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Movie extends Event{

	private LocalDateTime[] showTiming;
	private ArrayList<MovieTicket> bookings;

	public Movie(String name, String description, LocalDateTime[] showTiming, double price, String city, int maxSeats) {
		super(name, description, city, price, "Movie", maxSeats);
		this.showTiming = showTiming;
		this.bookings = new ArrayList<MovieTicket>();
	}

	public LocalDateTime[] getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(LocalDateTime[] showTiming) {
		this.showTiming = showTiming;
	}

	public ArrayList<MovieTicket> getBookings() {
		return bookings;
	}

	public void addBookings(MovieTicket booking) {
		bookings.add(booking);
	}

	@Override
	public void listAllBookings() {
		if(bookings.size() <= 0) {
			System.out.println("No Bookings till now");
		}
		else {
			System.out.printf("%-10s\t %-30s\t %-30s\t %-20s\t %-20s\n", "Id", "Name", "Show", "Seats", "Amount");
			for (Ticket ticket : bookings) {
				MovieTicket movieBooking = (MovieTicket) ticket;
				System.out.println(movieBooking);
			}
		}
	}
}
