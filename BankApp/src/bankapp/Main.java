
package bankapp;

import java.awt.Choice;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        Account a1 = new Account();
        System.out.println("press '1' if you want to learn your amount of money.");
        System.out.println("press '2' if you want to withdrawal.");
        System.out.println("press '3' if you want to investmen.");
        System.out.println("press 'q' if you waant quick.");
        
        while(true){
            System.out.print("What you want to do: ");
        String choice = ss.next();
        switch (choice) {
            case "1":
                System.out.println("Your amount of money is :"+a1.getAmount());
                break;
            case "2":
                System.out.print("Enter the amount you want to withdraw: ");
                double withdraw = ss.nextDouble();
                a1.setAmount((a1.getAmount())-withdraw);
                System.out.println("Your new amount of money is : "+a1.getAmount());
                break;
            case "3":
                System.out.print("Enter the amount you want to investmen: ");
                double investmen = ss.nextDouble();
                a1.setAmount((a1.getAmount())+investmen);
                System.out.println("Your new amount of money is : "+a1.getAmount());
                break;
            case "q":
                System.out.println("Thank you to prefer to us , have a nice day...");
                System.exit(0);
                break;
                
            default:
                System.out.println("you enter wrong operator!!!!");
                
        }
        
        }
    }
    
}
