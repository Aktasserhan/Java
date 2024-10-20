
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        System.out.print("Enter your weight: ");
        double userWeight = ss.nextDouble();
        System.out.print("Enter your height: ");
        double userHeight = ss.nextDouble();
        double index = (userWeight / (userHeight * userHeight));
        System.out.println("Your body mass index : " + index);
    }
}
