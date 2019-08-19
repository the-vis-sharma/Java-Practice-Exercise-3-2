package in.stackroute.eventregistry;

import java.util.ArrayList;
import java.util.Scanner;

public class EventController {

    public static void showMainMenu(EventStore registry) {

        Scanner sc = new Scanner(System.in);

        System.out.println("::: Main Menu :::");
        System.out.println("1. Search Event\n2. List Events\n3. Analytics\n4. Exit");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Event Types: \nMovie\nTrip");
                System.out.println("Enter event to search: ");
                String query = sc.nextLine();
                ArrayList<Event> searchResult = registry.searchEvent(query);
                if(searchResult.size() <= 0) {
                    System.out.println("No result found.");
                    if(promptContinue()) {
                        showMainMenu(registry);
                    }
                    else {
                        exit();
                    }
                }
                else {
                    registry.printEventList(searchResult);
                    Event selectedEvent = getSelectedEvent(searchResult);
                    showBookingMenu(registry, selectedEvent);
                }
                break;

            case 2:
                ArrayList<Event> allEvents = registry.listAllEvent();
                registry.printEventList(allEvents);
                Event event = getSelectedEvent(allEvents);
                showBookingMenu(registry, event);
                break;

            case 3:
                registry.showAnalytics();
                if(promptContinue()) {
                    showMainMenu(registry);
                }
                else {
                    exit();
                }
            break;

            case 4:
                exit();
            break;

            default:
                System.out.println("Invalid Option. Try again");
                showMainMenu(registry);
        }
    }

    public static void showBookingMenu(EventStore registry, Event event) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("::: Booking Menu (%s) :::\n", event.getName());
        System.out.println("1. Book Ticket\n2. List Bookings\n3. Exit");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                book(event);
                if(promptContinue()) {
                    showMainMenu(registry);
                }
                else {
                    exit();
                }
                break;

            case 2:
                showAllBookings(event);
                if(promptContinue()) {
                    showMainMenu(registry);
                }
                else {
                    exit();
                }
                break;

            case 3:
                exit();
                break;

            default:
                System.out.println("Invalid Option. Try again");
                showBookingMenu(registry, event);
        }
    }

    public static Event getSelectedEvent(ArrayList<Event> events) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Event Id to select: ");
        int selectedEventId = sc.nextInt();

        for(Event event : events) {
            if(event.getEventId()==selectedEventId) {
                return event;
            }
        }

        System.out.println("This Event is does not exists. Try again");
        return getSelectedEvent(events);
    }

    public static void book(Event event) {
        if(event.getType().equalsIgnoreCase("Movie")) {
            MovieTicket bookingHandler = new MovieTicket();
            if(bookingHandler.bookTicket(event)) {
                bookingHandler.printTicket();
            }
            else {
                System.out.println("Oops! can't book your ticket.");
            }
        }
        else if(event.getType().equalsIgnoreCase("Trip")) {
            TripTicket bookingHandler = new TripTicket();
            if (bookingHandler.bookTicket(event)) {
                bookingHandler.printTicket();
            } else {
                System.out.println("Oops! can't book your ticket.");
            }
        }
    }

    public static void showAllBookings(Event event) {
        if(event.getType().equalsIgnoreCase("Movie")) {
            Movie movie = (Movie) event;
            movie.listAllBookings();
        }
        else if(event.getType().equalsIgnoreCase("Trip")) {
           Trip trip = (Trip) event;
           trip.listAllBookings();
        }
    }

    public static boolean promptContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue: (Y/N)");
        String response = sc.nextLine();

        return response.equalsIgnoreCase("Y");
    }

    public static void exit() {
        System.out.println("Thanks for using our application.");
        System.exit(0);
    }
}
