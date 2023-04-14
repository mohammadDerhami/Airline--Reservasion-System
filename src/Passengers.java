package src;

import java.util.Scanner;

public class Passengers {
    private String userName;
    private String password;
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
    public void passengersSwitch()
    {

        while (true)
        {
            printPassengersMenu();
            System.out.println("number : ");
            switch (scanner.next())
            {
                case "1":
                {
                        passengersChangePassword();
                        passengersSwitch();
                        break;
                }
                case "2":
                {

                }
                case "3":
                {

                }
                case "4":
                {

                }
                case "5":
                {

                }
                case "6":
                {

                }
                case "0":
                {

                }
            }
        }


    }
    public void passengersChangePassword()
    {

        System.out.println("enter your password : ");
        String password = scanner.next();


                if(getPassword().equals(password))
                {
                    System.out.println("enter new password : ");
                    setPassword(scanner.next());
                    System.out.println("your password is change :)");

                    return;

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
}
