package in.stackroute.eventregistry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EventStore {

	/*
	 * This class will handle all the operation require to perform on all the events such as search, load, filtering.
	 */

	private static ArrayList<Event> allEvents = new ArrayList<Event>();;

	public ArrayList<Event> searchEvent(String q) {
		final String query = q.toLowerCase();
		return (ArrayList<Event>) allEvents.stream().filter(event -> {
			return event.getName().toLowerCase().contains(query) || event.getCity().toLowerCase().contains(query) ||
					event.getDescription().toLowerCase().contains(query) || event.getType().toLowerCase().contains(query);
		}).collect(Collectors.toList());
	}

	// this will return list of all the registered events
	public ArrayList<Event> listAllEvent() {
		return allEvents;
	}

	public void showAnalytics() {
		System.out.println("\nTotal Events Registered So Far: " + allEvents.size());

		int moviesCount = 0;
		int tripCount = 0;
		int totalMovieBookings = 0;
		int totalTripsBookings = 0;

		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-30s\t %-20s\n", "Event Name", "Total Bookings");
		System.out.println("--------------------------------------------------------------------");
		for(Event event : allEvents) {
			int bookings = 0;
			if(event.getType().equalsIgnoreCase("Movie")) {
				++moviesCount;
				bookings = ((Movie)event).getBookings().size();
				totalMovieBookings += bookings;

			}
			else if(event.getType().equalsIgnoreCase("Trip")) {
				++tripCount;
				bookings = ((Trip)event).getBookings().size();
				totalTripsBookings += bookings;
			}
			System.out.printf("%-30s\t %-20s\n", event.getName(), bookings);
		}
		System.out.println("--------------------------------------------------------------------\n");

		System.out.println("Total Movies: " + moviesCount);
		System.out.println("Total Trips: " + tripCount);
		System.out.println("Total Movies Tickets Booked: " + totalMovieBookings);
		System.out.println("Total Trips Tickets Booked: " + totalTripsBookings);
	}

	//print the given array list of the events in tabular format
	public void printEventList(ArrayList<Event> events) {
		System.out.printf("%-10s\t %-30s\t %-20s\t %-20s\t %-20s\n", "Id", "Name", "Type", "City", "Price");
		events.stream().forEach(event -> System.out.println(event));
	}


	public void initialiseDummyEvents() {
		LocalDateTime[] timings = new LocalDateTime[] {
				LocalDateTime.of(2019, 8, 20, 1, 30),
				LocalDateTime.of(2019, 8, 20, 9, 30),
				LocalDateTime.of(2019, 8, 21, 10, 00)
		};

		allEvents.add(new Movie("Avengers : End Game", "Marvel Movie", timings, 150.0, "Banglore", 150));
		allEvents.add(new Trip("Bombay to Goa", "3 Days amazing trip with your friends", 5000.0, "Jaipur", timings[0], 3, 50));
		allEvents.add(new Trip("Trip to Kasool", "5 Days amazing trip with your friends", 15000.0, "Banglore", timings[2], 5, 30));
	}
}
