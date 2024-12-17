import java.util.Scanner;

public class RetailStore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables for prices and totals
        double total = 0.0;
        double taxRate = 0.1; 
        double discRate = 0.05; 

        // Input for number of items
        System.out.println("Retail Store System");
        System.out.println("Enter number of items:");
        int itemCount = sc.nextInt();

        // Input and calculations for each item
        for (int i = 1; i <= itemCount; i++) {
            System.out.println("Enter price for item " + i + ": ");
            double price = sc.nextDouble();

            System.out.println("Enter quantity for item " + i + ": ");
            int qty = sc.nextInt();

            total += price * qty; // Add to total
        }

        // Calculate tax and discount
        double tax = total * taxRate;
        double disc = total * discRate;

        // Final total after tax and discount
        double finalTotal = total + tax - disc;

        // Output results
        System.out.printf("\nSubtotal: $%.2f\n", total);
        System.out.printf("Tax (10%%): $%.2f\n", tax);
        System.out.printf("Discount (5%%): -$%.2f\n", disc);
        System.out.printf("Final Total: $%.2f\n", finalTotal);

        sc.close();
    }
}
