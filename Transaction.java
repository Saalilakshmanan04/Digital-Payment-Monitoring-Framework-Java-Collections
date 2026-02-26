public class Transaction {

    private String transactionId;
    private String userId;
    private double amount;

    public Transaction(String transactionId, String userId, double amount) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
    }

    public String getTransactionId() { return transactionId; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return transactionId + " | " + userId + " | " + amount;
    }
}
