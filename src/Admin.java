package src;

import java.util.Scanner;

public class Admin {
    public Scanner scanner = new Scanner(System.in);

    public void adminMenu() {
        System.out.println(
                "           Admin MENUE OPTIONS\n" +
                        " ......................................\n" +
                        "    <1> Add\n" +
                        "    <2> Update\n" +
                        "    <3> Remove\n" +
                        "    <4> Flight schedules\n" +
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
    public void adminSwitch()
    {
        System.out.println("enter your number : ");
        String number = scanner.next();
        switch (number) {
            case "1": {

                break;
            }
            case "2": {

            }
            case "3": {

            }
            case "4": {

                break;

            }
            case "0": {

            }
            default: {


            }

        }
    }
}
