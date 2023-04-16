package src;

import java.util.Random;
import java.util.Scanner;

public class Passengers {
    private String userName;
    private String password;
    private double CREDIT = 0 ;
    public static String[] ticketId = new String[20];
    Scanner scanner = new Scanner(System.in);

    public void printPassengersMenu()
    {
        System.out.println("    PASSENGER MENU OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "    <1> Change password\n" +
                "    <2> Search flight tickets\n" +
                "    <3> Booking ticket\n" +
                "    <4> Ticket cancelation\n" +
                "    <5> Booked tickets\n" +
                "    <6> Add charge\n" +
                "    <0> Sign out");
    }
    public void passengersSwitch(Flights flights , Passengers [] passengers)
    {

        while (true)
        {
            printPassengersMenu();
            System.out.println("number : ");
            switch (scanner.next())
            {
                case "1":
                {
                        passengersChangePassword(flights , passengers);
                        passengersSwitch(flights , passengers);
                        break;
                }
                case "2":
                {
                        searchFlightTickets(flights , passengers);
                        break;
                }
                case "3":
                {
                        bookingTicket(flights , passengers);
                        break;
                }
                case "4":
                {
                    ticketCancel(flights, passengers);
                        break;
                }
                case "5":
                {
                        break;
                }
                case "6":
                {
                    passengersAddCharge();
                    passengersSwitch(flights , passengers);
                    break;
                }
                case "0":
                {
                    return;
                }
                default:
                {
                    System.out.println("Wrong number !!!");
                    passengersSwitch(flights , passengers);
                }
            }
        }


    }
    public void passengersChangePassword(Flights flights , Passengers[] passengers)
    {

        System.out.println("enter your password : ");
        String password = scanner.next();


                if(getPassword().equals(password))
                {
                    System.out.println("enter new password : ");
                    setPassword(scanner.next());
                    System.out.println("your password is change :)");
                    passengersSwitch(flights , passengers);
                }
                else
                {
                    System.out.println("password is Wrong !!! ");
                    passengersChangePassword(flights , passengers);
                }



    }
    public void passengersAddCharge()

    {


        System.out.println("how much do you want to increase your credit ?? ");
        int increaseCredit = scanner.nextInt();
        CREDIT = CREDIT + increaseCredit;

        System.out.println("your credit is "+CREDIT+" $");


    }
    public void bookingTicket(Flights flights , Passengers[] passengers)
    {
        System.out.println("your charge : "+getCredit());
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        System.out.println("enter id of flight : ");
        String id = scanner.next();
        for (int i = 0; i < flights.flight.length; i++) {
            if(flights.flight[i]!=null)
            {
                if (flights.flight[i].getFlightId().equals(id))
                {
                    if (flights.flight[i].getSeats() >= 1)
                    {
                        if (getCREDIT() >= flights.flight[i].getPrice())
                        {

                            setCREDIT(getCREDIT()-flights.flight[i].getPrice());
                            flights.flight[i].setSeats(flights.flight[i].getSeats() - 1);
                            for (int j = 0; j < ticketId.length; j++) {
                                if(ticketId[j] == null)
                                {

                                    ticketId[j] = flights.flight[i].getFlightId() + "-" + randomNumber;
                                    System.out.println("your ticketId is : " + ticketId[j] + "\nplease make a note  ");
                                    passengersSwitch(flights, passengers);
                                }
                            }
                        }
                        else
                        {
                            System.out.println("your credit is not enough !!!");
                           passengersSwitch(flights, passengers);
                        }
                    } else {
                        System.out.println("The flight is fully booked !!!");
                        passengersSwitch(flights, passengers);
                    }
                }
            }
        }
        System.out.println("Wrong id !!!\n");
        bookingTicket(flights, passengers);
    }
    public void ticketCancel(Flights flights , Passengers[] passengers)
    {
        System.out.println("enter your ticket id : ");
        String ticketId = scanner.next();
        for (int i = 0; i < flights.flight.length; i++) {

            if(ticketId!=null)
            {
                if (ticketId.startsWith(flights.flight[i].getFlightId())) {
                    flights.flight[i].setSeats(flights.flight[i].getSeats() + 1);
                    setCREDIT(getCREDIT() + flights.flight[i].getPrice());
                    ticketId = null;
                    System.out.println(" seccesfull :) ");
                    passengersSwitch(flights, passengers);

                }
            }
        }
        System.out.println("Wrong ticket id !!!!");
        ticketCancel(flights, passengers);
    }
    public void searchFlightTickets(Flights flights , Passengers[] passengers)
    {
        while (true)
        {
            System.out.println("\n\n\n");
            searchFlightTicketsMenu();
            switch (scanner.next())
            {
                case "1":
                {
                    System.out.println("enter id of flight : ");
                    String idOfFlight = scanner.next();
                    searchId(flights , idOfFlight);
                    break;
                }
                case "2":
                {
                    System.out.println("enter origin of flight : ");
                    String origin = scanner.next();
                    searchOrigin(flights , origin);
                    break;
                }
                case "3":
                {
                    System.out.println("enter distination of flight : ");;
                    String distination = scanner.next();
                    searchDestinition(flights , distination);
                    break;
                }
                case "4":
                {
                    System.out.println("enter date of flight : ");
                    String date = scanner.next();
                    searchDate(flights , date);
                    break;
                }
                case "5":
                {
                    System.out.println("enter time of flight : ");
                    String time = scanner.next();
                    searchTime(flights , time);
                    break;
                }
                case "6":
                {
                    System.out.println("enter min price : ");
                    double min = scanner.nextDouble();
                    System.out.println("enter max price : ");
                    double  max = scanner.nextDouble();
                    searchPrice(flights , min , max);
                    break;

                }
                case "0":
                {
                    passengersSwitch(flights ,passengers );
                    break;
                }
                default:
                {
                    System.out.println("Wrong number !!!!");
                    searchFlightTickets(flights , passengers);
                    break;

                }
            }
        }

    }
    public void searchFlightTicketsMenu()
    {
        System.out.println("1: FlightId\n2: Origin\n3: Destination\n4: Date\n5: Time\n6: Price range\n0: back \n");
        System.out.println("enter your number : ");
    }
    public void searchId(Flights flights , String id)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(flights.flight[i].getFlightId().equals(id))
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }

    }
    public void searchOrigin(Flights flights , String origin)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(flights.flight[i].getOrigin().equals(origin))
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }


    }
    public void searchDate(Flights flights , String date)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(flights.flight[i].getDate().equals(date))
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }
    }
    public void searchTime(Flights flights , String time)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(flights.flight[i].getTime().equals(time))
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }
    }
    public void searchDestinition(Flights flights , String distination)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(flights.flight[i].getDestination().equals(distination))
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }
    }

    public void searchPrice(Flights flights , double minPrice , double maxPrice)
    {
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s \n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "seats");
        System.out.printf("...........................................................................................................%n");
        for (int i = 0; i < flights.flight.length ; i++) {
            if(flights.flight[i] != null)
            {
                if(maxPrice >= flights.flight[i].getPrice() && flights.flight[i].getPrice() >= minPrice )
                {
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s|%-15s |%-15s |%-15s \n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeats());
                    System.out.printf("...........................................................................................................%n");
                }
            }
        }
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCredit() {
        return CREDIT;
    }

    public void setCredit(double credit) {
        this.CREDIT = CREDIT;
    }

    public double getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(double CREDIT) {
        this.CREDIT = CREDIT;
    }

    public String[] getTicketId() {
        return ticketId;
    }

    public void setTicketId(String[] ticketId) {
        this.ticketId = ticketId;
    }
}

