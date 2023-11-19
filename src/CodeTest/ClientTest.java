package CodeTest;

import Code.Client;
import Code.RealEstate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {


    @Test
    void setEmail() {
        Client client = new Client();

        client.setEmail("test@example.com");
        assertEquals("test@example.com", client.getEmail());
    }


    @Test
    void setWallet() {
        Client client = new Client();

        client.setWallet("100.50");
        assertEquals(new BigDecimal("100.50"), client.getWallet());

    }

    @Test
    void equalsAndHashCode() {
        Client client1 = new Client();
        client1.setId(1L);
        client1.setEmail("test@example.com");

        Client client2 = new Client();
        client2.setId(1L);
        client2.setEmail("test@example.com");

        Client client3 = new Client();
        client3.setId(2L);
        client3.setEmail("different@example.com");

        assertEquals(client2, client1);
        assertNotEquals(client3, client1);
        assertEquals(client2.hashCode(), client1.hashCode());
        assertNotEquals(client3.hashCode(), client1.hashCode());
    }

    @Test
    void toStringTest() {
        Client client = new Client();
        client.setId(1L);
        client.setEmail("test@example.com");

        String expectedToString = "Client{id=1, realEstates=[], email='test@example.com', phoneNumber='null', wallet=null} Person{firstName='null', lastName='null', dateOfBrith=null}";
        assertEquals(expectedToString, client.toString());
    }

    @Test
    void setRealEstates() {
        Client client = new Client();
        Set<RealEstate> realEstates = new HashSet<>();
        RealEstate realEstate = new RealEstate();
        realEstates.add(realEstate);

        client.setRealEstates(realEstates);
        assertEquals(realEstates, client.getRealEstates());
    }
}