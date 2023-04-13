package src;

import java.util.Scanner;

public class MainMenu
{
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
    public void switchMethod()
    {

        while (true)
        {
            printMenu();
            System.out.println("");
            String number = scanner.next();
            switch (number) {
                case "1": {

                    break;

                }
                case "2": {


                    break;
                }
                default: {
                    System.out.println("Wrong number ");
                    switchMethod();
                    break;

                }
            }
        }

    }
}
