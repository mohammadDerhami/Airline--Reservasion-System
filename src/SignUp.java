package src;

import java.util.Scanner;

public class SignUp {
    Scanner scanner = new Scanner(System.in);
    public void SignUpMethod(Passengers[] passengers , int counter) {

        System.out.println("enter your username :");
        passengers[counter] = new Passengers();
        passengers[counter].setUserName(scanner.next());
        System.out.println("enter your password ;");
        passengers[counter].setPassword(scanner.next());



    }
}
