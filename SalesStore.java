import java.util.Scanner;

public class SalesStore {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine v = new VendingMachine();
        int option, res;
        float value;

        do {
            System.out.println(v.showInfo());
            System.out.println("Enter 99 to add credit");
            System.out.println("Enter -1 to to exit");
            System.out.println("Or type Soda number from (0-4)");
            option = scanner.nextInt();
            switch (option) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                res = v.buy(option);
                if (res == 0) {
                    System.out.println("Enjoy!");
                } else if (res == -1) {
                    System.out.println("Please Add more credit(Money) on your Card");
                } else {
                    System.out.println("Out of Order, Please check later!");
                }
                break;

            case 99:
                System.out.println("Type the value: ");
                value = scanner.nextFloat();
                v.insertCredit(value);
                break;
            case -1:
                System.out.println("Thank you for use the Vending Machine");
                System.out.println("Please take your change " + v.requestChange());
                break;
            default:
                System.out.println("Invalid Option");

            }

        } while (option != -1);
    }
}
