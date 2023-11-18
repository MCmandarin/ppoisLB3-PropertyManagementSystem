package Code;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Agent {
    private Set<Transaction> transactions;

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean addTransaction(Transaction transaction) {
        if (transactions.contains(transaction)) {
            return false;
        }
        transactions.add(transaction);
        return true;
    }

    public boolean deleteTransaction(Transaction transaction) {
        if (transactions.contains(transaction)) {
            transactions.remove(transaction);
            return true;
        }
        return false;
    }

    private void checkingBeforeTheTransaction(Transaction transaction){
        if (!transactions.contains(transaction)) {
            throw new IllegalArgumentException("This transaction does not exist");
        }

        if (transaction.getRealEstate() == null || transaction.getClient() == null || transaction.getPrice() == null) {
            throw new RuntimeException("It is impossible to conduct a client-real estate transaction");
        }

        if (transaction.getClient().getWallet().longValue() < transaction.getPrice().longValue()) {
            throw new RuntimeException("Not enough money in the purse");
        }
        transactions.remove(transaction);
    }

    public void TransactionExecutionOnPurchase(Transaction transaction) {
        checkingBeforeTheTransaction(transaction);

        BigDecimal newWallet;
        newWallet = transaction.getClient().getWallet().subtract(transaction.getPrice());
        transaction.getClient().setWallet(newWallet.toString());
        transaction.getClient().addRealEstate(transaction.getRealEstate());
        transaction.setCompleted(true);

        transactions.add(transaction);
    }

    public void TransactionExecutionOnSale(Transaction transaction){
        checkingBeforeTheTransaction(transaction);
        if(!transaction.getClient().getRealEstates().contains(transaction.getRealEstate())){
            throw new RuntimeException("This client does not own this property");
        }
        BigDecimal newWallet;
        newWallet = transaction.getClient().getWallet().add(transaction.getPrice());
        transaction.getClient().setWallet(newWallet.toString());
        transaction.getClient().deleteRealEstate(transaction.getRealEstate());
        transaction.setCompleted(true);

        transactions.add(transaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(transactions, agent.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactions);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "transactions=" + transactions +
                '}';
    }
}
