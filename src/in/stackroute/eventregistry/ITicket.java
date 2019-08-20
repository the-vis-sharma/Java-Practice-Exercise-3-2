package in.stackroute.eventregistry;

public interface ITicket {

    /*
     * This is parent interface for all types of event tickets.
     */

    boolean bookTicket(Event movie);
    void printTicket();
}
