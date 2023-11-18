package Code;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {
    private RealEstate realEstate;
    private Client client;
    final private TransactionType transactionType;
    private BigDecimal price;
    private boolean isCompleted;

    public Transaction(TransactionType transactionType){
        this.transactionType = transactionType;
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate property) {
        this.realEstate = property;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return isCompleted == that.isCompleted && Objects.equals(realEstate, that.realEstate) && Objects.equals(client, that.client) && transactionType == that.transactionType && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realEstate, client, transactionType, price, isCompleted);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "realEstate=" + realEstate +
                ", client=" + client +
                ", transactionType=" + transactionType +
                ", price=" + price +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
