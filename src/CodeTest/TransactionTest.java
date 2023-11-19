package CodeTest;

import Code.Client;
import Code.RealEstate;
import Code.Transaction;
import Code.TransactionType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @Test
    void constructor() {
        Transaction transaction = new Transaction(TransactionType.SALE);

        assertEquals(TransactionType.SALE, transaction.getTransactionType());
        assertFalse(transaction.isCompleted());
        assertNull(transaction.getRealEstate());
        assertNull(transaction.getClient());
        assertNull(transaction.getPrice());
    }

    @Test
    void settersAndGetters() {
        Transaction transaction = new Transaction(TransactionType.PURCHASE);
        RealEstate realEstate = new RealEstate();
        Client client = new Client();

        transaction.setRealEstate(realEstate);
        assertEquals(realEstate, transaction.getRealEstate());

        transaction.setClient(client);
        assertEquals(client, transaction.getClient());

        transaction.setPrice("150.75");
        assertEquals(new BigDecimal("150.75"), transaction.getPrice());

        transaction.setCompleted(true);
        assertTrue(transaction.isCompleted());
    }

    @Test
    void equalsAndHashCode() {
        Transaction transaction1 = new Transaction(TransactionType.SALE);
        transaction1.setPrice("100.50");
        Transaction transaction2 = new Transaction(TransactionType.SALE);
        transaction2.setPrice("100.50");
        Transaction transaction3 = new Transaction(TransactionType.PURCHASE);

        assertEquals(transaction2, transaction1);
        assertNotEquals(transaction3, transaction1);
        assertEquals(transaction2.hashCode(), transaction1.hashCode());
        assertNotEquals(transaction3.hashCode(), transaction1.hashCode());
    }

    @Test
    void toStringTest() {
        Transaction transaction = new Transaction(TransactionType.PURCHASE);
        RealEstate realEstate = new RealEstate();
        Client client = new Client();
        transaction.setRealEstate(realEstate);
        transaction.setClient(client);
        transaction.setPrice("200.25");
        transaction.setCompleted(true);

        String expectedToString = "Transaction{" +
                "realEstate=" + realEstate +
                ", client=" + client +
                ", transactionType=" + TransactionType.PURCHASE +
                ", price=" + new BigDecimal("200.25") +
                ", isCompleted=true" +
                '}';
        assertEquals(expectedToString, transaction.toString());
    }
}