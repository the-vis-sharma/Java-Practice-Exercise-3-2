package in.stackroute.eventregistry;

import java.util.Scanner;

public class TripTicket extends Ticket {

    @Override
    public boolean bookTicket(Event trip) {
        Trip tripObj = (Trip) trip;

        if(tripObj.getBookings().size() == trip.getMaxSeats()) {
            System.out.println("All Tickets are already sold out.");
            return false;
        }

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        id = tripObj.getBookings().size() + 1;

        System.out.println("Your Name:");
        customerName = sc.nextLine();

        dateTime = tripObj.getDateTime();

        System.out.println("How many peoples are there: ");
        seats = Integer.parseInt(sc.nextLine());

        amount = tripObj.getPrice() * seats;

        System.out.printf("You need to pay Rs. %.2f, Below are payment methods -\n", amount);
        int count = 0;
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
        tripObj.addBookings(this);
        return true;
    }

    @Override
    public void printTicket() {
        System.out.println("Here is your ticket: \n");
        System.out.println("----------------------------");
        System.out.println("Name: " + customerName);
        System.out.println("Date: " + dateTime);
        System.out.println("Seats: " + seats);
        System.out.println("Amount Paid: " + amount);
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        return String.format("%-10s\t %-30s\t %-30s\t %-20s\t %-20s", id, customerName, dateTime, seats, amount);
    }

}
