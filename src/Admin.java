package src;

import java.util.Scanner;

public class Admin {
    public Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        System.out.println("           Admin MENUE OPTIONS\n" + " ......................................\n" + "    <1> Add\n" + "    <2> Update\n" + "    <3> Remove\n" + "    <4> Flight schedules\n" + "    <0> Sign out");
    }

    public String getAdminUserName() {
        String adminUserName = "Admin";
        return adminUserName;
    }

    public String getAdminPassword() {
        String adminPassword = "Admin";
        return adminPassword;
    }

    public void adminSwitch(Flights flights) {
        System.out.println("enter your number : ");
        String number = scanner.next();
        switch (number) {
            case "1": {
                adminAdd(flights);
                adminMenu();
                adminSwitch(flights);

                break;
            }
            case "2": {

            }
            case "3": {

            }
            case "4": {
                adminFlightSchedules(flights);
                adminMenu();
                adminSwitch(flights);

                break;

            }
            case "0": {
                return;

            }
            default: {
                System.out.println("Wrong number !!!!");
                adminSwitch(flights);



            }

        }
    }

    public void adminAdd(Flights flights) {

        for (int i = 0; i < flights.flight.length; i++) {
            if (flights.flight[i] == null) {
                flights.flight[i] = new Flight();
                System.out.println("enter flightId : ");
                flights.flight[i].setFlightId(scanner.next());
                System.out.println("enter origin : ");
                flights.flight[i].setOrigin(scanner.next());
                System.out.println("enter destination : ");
                flights.flight[i].setDestination(scanner.next());
                System.out.println("enter date : ");
                flights.flight[i].setDate(scanner.next());
                System.out.println("enter time : ");
                flights.flight[i].setTime(scanner.next());
                System.out.println("enter price : ");
                flights.flight[i].setPrice(scanner.next());
                System.out.println("enter seats : ");
                flights.flight[i].setSeats(scanner.next());
                System.out.println("flight aded :) ");
                return;
            }

        }

    }

    public void adminFlightSchedules(Flights flights) {
        flights.defFlights(flights);
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length; i++) {
            if (flights.flight[i] != null) {
                System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                System.out.printf("...........................................................................................................%n");

            }
        }
    }
}
