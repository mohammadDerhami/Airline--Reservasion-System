package src;

import java.util.Scanner;

public class SignIn {
    public Scanner scanner = new Scanner(System.in);
    public void signInMethod(Admin admin , Passengers[] passengers , Flights flights , MainMenu mainMenu)
    {
        System.out.println("enter username : ");
        String username = scanner.next();
        System.out.println("enter password : ");
        String password = scanner.next();

        if(admin.getAdminUserName().equals(username))
        {
            if(admin.getAdminPassword().equals(password))
            {
                System.out.println("Welcome Admin \n");
                admin.adminMenu();
                admin.adminSwitch(flights, mainMenu, passengers, admin);
                return;
            }
            else
            {
                System.out.println("Wrong password!!!");
                signInMethod(admin, passengers, flights , mainMenu);

            }
        }
        for (int i = 0; i < passengers.length; i++) {

            if(passengers[i] != null)
            {


                if (passengers[i].getUserName().equals(username)) {
                    if (passengers[i].getPassword().equals(password)) {
                        System.out.println("Welcome  "+passengers[i].getUserName()+"\n");
                           passengers[i].passengersSwitch(flights , passengers , mainMenu ,admin);
                           return;


                    } else {
                        System.out.println("wrong password!!!!!!!\n\n\n");
                        signInMethod(admin, passengers ,flights ,mainMenu);

                    }
                }

            }
        }
        System.out.println("wrong user!!!!!!!!!!\n ");
        signInMethod(admin, passengers ,flights ,mainMenu);
    }
}
