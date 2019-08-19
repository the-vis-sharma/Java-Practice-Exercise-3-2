package in.stackroute.eventregistry;

public class Main {
    public static void main(String[] args) {
        EventStore registry = new EventStore();
        registry.initialiseDummyEvents();

        EventController.showMainMenu(registry);

    }
}
