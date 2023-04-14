package src;

import java.util.Scanner;

public class Admin {
    public Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        System.out.println("           Admin MENUE OPTIONS\n"
                + " ......................................\n"
                + "    <1> Add\n"
                + "    <2> Update\n"
                + "    <3> Remove\n"
                +
                "    <4> Flight schedules\n"
                +
                "    <0> Sign out");
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
                adminFlightSchedules(flights);
                adminUpdate(flights);
                adminMenu();
                adminSwitch(flights);
                break;
            }
            case "3": {
                adminFlightSchedules(flights);
                adminRemove(flights);
                adminMenu();
                adminSwitch(flights);

                break;

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

        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length; i++) {
            if (flights.flight[i] != null) {
                System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                System.out.printf("...........................................................................................................%n");

            }
        }
    }

    public void adminUPdateTable() {
        System.out.println("1: FlightId\n2: Origin\n3: Destination\n4: Date\n5: Time\n6: Price\n7: Seats\n8: back \n");
        System.out.println("enter your number : ");
    }

    public void adminUpdate(Flights flights) {
        int indexOfFlight = searchIdOfFlight(flights);
       if(indexOfFlight == -1)
       {
           System.out.println("Wrong id !!!");
           adminUpdate(flights);
       }



        while (true)
        {
            adminUPdateTable();

            switch (scanner.next()) {
                case "1": {
                    System.out.println("enter new FlightId : ");
                    flights.flight[indexOfFlight].setFlightId(scanner.next());
                    System.out.println("successful :)");
                    break;

                }
                case "2": {
                    System.out.println("enter new Origin : ");
                    flights.flight[indexOfFlight].setOrigin(scanner.next());
                    System.out.println("successful :)");
                    break;
                }
                case "3": {
                    System.out.println("enter new Destination : ");
                    flights.flight[indexOfFlight].setDestination(scanner.next());
                    System.out.println("successful :)");
                    break;
                }
                case "4": {
                    System.out.println("enter new Date : ");
                    flights.flight[indexOfFlight].setDate(scanner.next());
                    System.out.println("successful :)");
                    break;

                }
                case "5": {
                    System.out.println("enter new Time : ");
                    flights.flight[indexOfFlight].setTime(scanner.next());
                    System.out.println("successful :)");
                    break;
                }
                case "6": {
                    System.out.println("enter new Price : ");
                    flights.flight[indexOfFlight].setPrice(scanner.next());
                    System.out.println("successful :)");
                    break;
                }
                case "7": {
                    System.out.println("enter new Seats : ");
                    flights.flight[indexOfFlight].setSeats(scanner.next());
                    System.out.println("successful :)");
                    break;

                }
                case "8": {
                    return;

                }
                default: {
                    System.out.println("Wrong number !!!");
                    adminUpdate(flights);
                    break;
                }

            }
        }


    }

    public void adminRemove(Flights flights) {

        int indexOfFlight = searchIdOfFlight(flights);
        if(indexOfFlight == -1)
        {
            System.out.println("Wrong id !!!");
            adminRemove(flights);
        }
        flights.flight[indexOfFlight] = null;
        System.out.println("successful :)");
        return;


    }
    public int searchIdOfFlight(Flights flights)
    {
        System.out.println("enter id of flight : ");
        String idOfFlight = scanner.next();
        for (int i = 0; i < flights.flight.length ; i++) {
            if (flights.flight[i] != null)
            {
                if(flights.flight[i].getFlightId().equals(idOfFlight))
                {
                    return i;
                }
            }

        }
        return -1;
    }
}
