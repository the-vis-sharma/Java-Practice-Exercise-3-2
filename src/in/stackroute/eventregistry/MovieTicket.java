package in.stackroute.eventregistry;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MovieTicket extends Ticket {

    /*
     * Ticket for Movie. It will handle booking and printing ticket operations.
     */

    @Override
    public boolean bookTicket(Event movie) {
        Movie movieObj = (Movie) movie;
        if(movieObj.getBookings().size() == movieObj.getMaxSeats()) {
            System.out.println("All Tickets are already sold out.");
            return false;
        }
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        id = movieObj.getBookings().size() + 1;

        System.out.println("Your Name:");
        customerName = sc.nextLine();

        System.out.println("Show Timings: ");
        int count = 0;
        for(LocalDateTime dateTime : movieObj.getShowTiming()) {
            System.out.printf("%d - %s\n", (++count), dateTime.toString());
        }

        System.out.println("Enter your preferred Show choice: ");
        choice = Integer.parseInt(sc.nextLine())-1;
        if(choice >= 0 && choice <= movieObj.getShowTiming().length) {
            dateTime = movieObj.getShowTiming()[choice];
        }
        else {
            System.out.println("This is not a valid show timing.");
            return false;
        }

        System.out.println("How many seats you want: ");
        seats = Integer.parseInt(sc.nextLine());

        amount = movieObj.getPrice() * seats;

        System.out.printf("You need to pay Rs. %.2f, Below are payment methods -\n", amount);
        count = 0;
        for(String paymentMode : availablePaymentModes) {
            System.out.printf("%d - %s\n", (++count), paymentMode);
        }

        System.out.println("Please choose your payment method: ");
        choice = Integer.parseInt(sc.nextLine())-1;
        if(choice >= 0 && choice <= availablePaymentModes.length) {
            paymentMode = availablePaymentModes[choice];
        }
        else {
            System.out.println("This is not a valid payment mode.");
            return false;
        }
        paymentMode = availablePaymentModes[choice];

        status = "Confirmed";
        movieObj.addBookings(this);
        return true;
    }

    @Override
    public void printTicket() {
        System.out.println("Here is your ticket: \n");
        System.out.println("----------------------------");
        System.out.println("Name: " + customerName);
        System.out.println("Show: " + dateTime);
        System.out.println("Seats: " + seats);
        System.out.println("Amount Paid: " + amount);
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        return String.format("%-10s\t %-30s\t %-30s\t %-20s\t %-20s", id, customerName, dateTime, seats, amount);
    }
}
