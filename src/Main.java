package src;

public class Main
{
    public static Passengers[] passengers = new Passengers[20];
    public static Admin admin = new Admin();
    public static Flights flights = new Flights();
    public static void main(String[] args) {
        flights.defFlights(flights);
        MainMenu mainMenu = new MainMenu();
        mainMenu.switchMethod(passengers , admin ,flights);

    }

}
