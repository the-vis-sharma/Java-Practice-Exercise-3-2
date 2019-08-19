package in.stackroute.eventregistry;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Trip extends Event{

    private int noOfdays;
    private LocalDateTime dateTime;
    private ArrayList<TripTicket> bookings;


    public Trip(String name, String description, double price, String city, LocalDateTime dateTime, int noOfdays, int maxSeats) {
        super(name, description, city, price, "Trip", maxSeats);
        this.noOfdays = noOfdays;
        this.dateTime = dateTime;
        this.bookings = new ArrayList<TripTicket>();
    }

    public int getNoOfdays() {
        return noOfdays;
    }

    public void setNoOfdays(int noOfdays) {
        this.noOfdays = noOfdays;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ArrayList<TripTicket> getBookings() {
        return bookings;
    }

    public void addBookings(TripTicket booking) {
        this.bookings.add(booking);
    }

    @Override
    public void listAllBookings() {
        if(bookings.size() <= 0) {
            System.out.println("No Bookings till now");
        }
        else {
            System.out.printf("%-10s\t %-30s\t %-30s\t %-20s\t %-20s\n", "Id", "Name", "Show", "Seats", "Amount");
            for (Ticket ticket : bookings) {
                TripTicket tripBooking = (TripTicket) ticket;
                System.out.println(tripBooking);
            }
        }
    }
}
