import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        TransactionService service = new TransactionService();

        while (true) {
            System.out.println("\n1.Add Transaction");
            System.out.println("2.Show User Total");
            System.out.println("3.Show Top 3 Transactions");
            System.out.println("4.Show All Sorted");
            System.out.println("5.Exit");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Transaction ID: ");
                    String tId = scan.next();
                    System.out.print("User ID: ");
                    String uId = scan.next();
                    System.out.print("Amount: ");
                    double amt = scan.nextDouble();
                    service.addTransaction(new Transaction(tId, uId, amt));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    service.showUserTotal(scan.next());
                    break;

                case 3:
                    service.showTopTransactions();
                    break;

                case 4:
                    service.showAllTransactionsSorted();
                    break;

                case 5:
                    return;
            }
        }
    }
}
