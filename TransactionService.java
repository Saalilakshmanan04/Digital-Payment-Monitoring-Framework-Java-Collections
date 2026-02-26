import java.util.*;

public class TransactionService {

    private List<Transaction> transactionList = new ArrayList<>();
    private Set<String> transactionIds = new HashSet<>();
    private Map<String, Double> userTotals = new HashMap<>();

    public void addTransaction(Transaction t) {

        // Duplicate detection
        if (!transactionIds.add(t.getTransactionId())) {
            System.out.println("Duplicate Transaction Detected!");
            return;
        }

        transactionList.add(t);

        // Track user total spending
        userTotals.put(t.getUserId(),
                userTotals.getOrDefault(t.getUserId(), 0.0) + t.getAmount());

        // Flag high value transaction
        if (t.getAmount() > 100000) {
            System.out.println("High Value Transaction Alert!");
        }

        System.out.println("Transaction added successfully.");
    }

    public void showUserTotal(String userId) {
        double total = userTotals.getOrDefault(userId, 0.0);
        System.out.println("Total spent by " + userId + ": " + total);
    }

    public void showTopTransactions() {
        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());
        System.out.println("Top Transactions:");
        for (int i = 0; i < Math.min(3, transactionList.size()); i++) {
            System.out.println(transactionList.get(i));
        }
    }

    public void showAllTransactionsSorted() {
        TreeMap<Double, String> sortedMap = new TreeMap<>();

        for (Transaction t : transactionList) {
            sortedMap.put(t.getAmount(), t.toString());
        }

        System.out.println("Transactions sorted by amount:");
        sortedMap.forEach((amount, details) ->
                System.out.println(details));
    }
}