package src;

import java.util.Scanner;

public class SignUp {
    Scanner scanner = new Scanner(System.in);
//________________________method of sign up _______________________________
    public void signUpMethod(Passengers[] passengers, int counter) {

        System.out.println("enter your username :");
        passengers[counter] = new Passengers();
        String username = scanner.next();
        passengers[counter].setUserName(username);
        System.out.println("enter your password :");
        String password = scanner.next();
        passengers[counter].setPassword(password);
        System.out.println("Registration Was Successful ");
        return;


    }
}
