package CodeTest;

import Code.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AgentTest {
    @Test
    void addTransaction() {
        Agent agent = new Agent();
        Transaction transaction = new Transaction(TransactionType.PURCHASE);

        assertTrue(agent.addTransaction(transaction));
        assertFalse(agent.addTransaction(transaction)); // Adding the same transaction should return false
    }

    @Test
    void deleteTransaction() {
        Agent agent = new Agent();
        Transaction transaction = new Transaction(TransactionType.PURCHASE);

        assertFalse(agent.deleteTransaction(transaction)); // Deleting non-existent transaction should return false

        agent.addTransaction(transaction);
        assertTrue(agent.deleteTransaction(transaction));
        assertFalse(agent.deleteTransaction(transaction)); // Deleting the same transaction again should return false
    }

    @Test
    void transactionExecutionOnPurchase() {
        Agent agent = new Agent();
        Transaction transaction = createTransaction(TransactionType.PURCHASE);

        assertThrows(IllegalArgumentException.class, () -> agent.TransactionExecutionOnPurchase(transaction));

        agent.addTransaction(transaction);
        agent.TransactionExecutionOnPurchase(transaction);

        assertTrue(transaction.isCompleted());
        assertTrue(agent.getTransactions().contains(transaction));
        assertEquals(new BigDecimal("900"), transaction.getClient().getWallet());
        assertTrue(transaction.getClient().getRealEstates().contains(transaction.getRealEstate()));
    }

    @Test
    void transactionExecutionOnSale() {
        Agent agent = new Agent();
        Client client = new Client();

        RealEstate realEstate = new RealEstate();
        realEstate.setAddress("1");

        client.addRealEstate(realEstate);
        client.setWallet("1100");

        Transaction transaction = new Transaction(TransactionType.SALE);
        transaction.setRealEstate(realEstate);
        transaction.setClient(client);
        transaction.setPrice("1000");

        agent.addTransaction(transaction);
        agent.TransactionExecutionOnSale(transaction);

        assertTrue(transaction.isCompleted());
        assertTrue(agent.getTransactions().contains(transaction));
        assertEquals(new BigDecimal("2100"), transaction.getClient().getWallet());
        assertFalse(transaction.getClient().getRealEstates().contains(transaction.getRealEstate()));
    }

    private Transaction createTransaction(TransactionType type) {
        RealEstate realEstate = new RealEstate();
        Client client = new Client();
        client.setWallet("1000");
        Transaction transaction = new Transaction(type);
        transaction.setRealEstate(realEstate);
        transaction.setClient(client);
        transaction.setPrice("100");

        return transaction;
    }

    @Test
    void equalsAndHashCode() {
        Agent agent1 = new Agent();
        Agent agent2 = new Agent();
        Agent agent3 = new Agent();
        Transaction transaction = createTransaction(TransactionType.PURCHASE);

        agent1.addTransaction(transaction);
        agent2.addTransaction(transaction);

        assertEquals(agent2, agent1);
        assertNotEquals(agent3, agent1);
        assertEquals(agent2.hashCode(), agent1.hashCode());
        assertNotEquals(agent3.hashCode(), agent1.hashCode());
    }

    @Test
    void toStringTest() {
        Agent agent = new Agent();
        Transaction transaction = createTransaction(TransactionType.PURCHASE);

        agent.addTransaction(transaction);

        String expectedToString = "Agent{" +
                "transactions=" + agent.getTransactions() +
                '}';
        assertEquals(expectedToString, agent.toString());
    }
}