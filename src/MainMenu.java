package src;

import java.util.Scanner;

public class MainMenu
{
    public int counter = 0;
    Scanner scanner = new Scanner(System.in);
    public void printMenu()
    {
        System.out.println(
                "           WELCOME TO AIRELINE RESERVATION SYSTEM\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "..........................MENU OPTIONS........................\n" +
                "\n" +
                "    <1> Sign in\n" +
                "    <2> Sign up ");
    }
    public void switchMethod(Passengers[] passengers , Admin admin , Flights flights)
    {

        while (true)
        {
            printMenu();
            System.out.println("");
            String number = scanner.next();
            switch (number) {
                case "1": {
                    SignIn signIn = new SignIn();
                    signIn.signIn( admin ,passengers ,flights);
                        break;

                }
                case "2": {
                    SignUp signUp = new SignUp();
                    signUp.SignUpMethod( passengers, counter);
                    counter++;
                        break;
                }
                default: {
                    System.out.println("Wrong number ");
                    switchMethod( passengers , admin , flights);
                        break;

                }
            }
        }

    }
}
