
package switchcase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner ss = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = ss.nextInt();
        System.out.print("Enter secont number: ");
        int n2 = ss.nextInt();
        System.out.print("Enter operator: ");
        String op = ss.next();
        switch (op) {
            case "+":
                System.out.println("Result : "+(n1+n2));
                break;
            case "-":
                System.out.println("Result : "+(n1-n2));
                break;
            default:
                System.out.println("you enter wrong operation");
                throw new AssertionError();
        }
    }
    
}
