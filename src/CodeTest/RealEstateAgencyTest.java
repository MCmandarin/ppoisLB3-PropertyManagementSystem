package CodeTest;

import Code.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RealEstateAgencyTest {
    @Test
    void addAvailableRealEstate() {
        RealEstateAgency agency = new RealEstateAgency();
        RealEstate realEstate = new RealEstate();

        assertTrue(agency.addAvailableRealEstate(realEstate));
        assertFalse(agency.addAvailableRealEstate(realEstate)); // Adding the same real estate should return false
    }

    @Test
    void deleteAvailableRealEstate() {
        RealEstateAgency agency = new RealEstateAgency();
        RealEstate realEstate = new RealEstate();

        assertFalse(agency.deleteAvailableRealEstate(realEstate)); // Deleting non-existent real estate should return false

        agency.addAvailableRealEstate(realEstate);
        assertTrue(agency.deleteAvailableRealEstate(realEstate));
        assertFalse(agency.deleteAvailableRealEstate(realEstate)); // Deleting the same real estate again should return false
    }

    @Test
    void addClient() {
        RealEstateAgency agency = new RealEstateAgency();
        Client client = new Client();

        assertTrue(agency.addClient(client));
        assertFalse(agency.addClient(client)); // Adding the same client should return false
    }

    @Test
    void deleteClient() {
        RealEstateAgency agency = new RealEstateAgency();
        Client client = new Client();

        assertFalse(agency.deleteClient(client)); // Deleting non-existent client should return false

        agency.addClient(client);
        assertTrue(agency.deleteClient(client));
        assertFalse(agency.deleteClient(client)); // Deleting the same client again should return false
    }

    @Test
    void addPositionEmployees() {
        RealEstateAgency agency = new RealEstateAgency();
        AgencyEmployee employee = new AgencyEmployee();
        PositionInTheCompany position = PositionInTheCompany.ACCOUNTANT;

        assertThrows(IllegalArgumentException.class, () -> agency.addPositionEmployees(position, employee));

        employee.setPosition(PositionInTheCompany.ACCOUNTANT);
        agency.addPositionEmployees(PositionInTheCompany.ACCOUNTANT, employee);

        assertTrue(agency.getEmployees().containsKey(PositionInTheCompany.ACCOUNTANT));
        assertEquals(1, agency.getEmployees().get(PositionInTheCompany.ACCOUNTANT).size());
        assertTrue(agency.getEmployees().get(PositionInTheCompany.ACCOUNTANT).contains(employee));
    }

    @Test
    void deletePositionEmployees() {
        RealEstateAgency agency = new RealEstateAgency();
        AgencyEmployee employee = new AgencyEmployee();
        PositionInTheCompany position = PositionInTheCompany.ACCOUNTANT;

        employee.setPosition(PositionInTheCompany.ACCOUNTANT);
        agency.addPositionEmployees(PositionInTheCompany.ACCOUNTANT, employee);

        assertTrue(agency.getEmployees().containsKey(PositionInTheCompany.ACCOUNTANT));

        agency.deletePositionEmployees(PositionInTheCompany.ACCOUNTANT);

        assertFalse(agency.getEmployees().containsKey(PositionInTheCompany.ACCOUNTANT));
    }

    @Test
    void addEmployee() {
        RealEstateAgency agency = new RealEstateAgency();
        AgencyEmployee employee = new AgencyEmployee();

        employee.setPosition(PositionInTheCompany.ACCOUNTANT);
        agency.addPositionEmployees(PositionInTheCompany.ACCOUNTANT, employee);

        List<AgencyEmployee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        assertEquals(employeeList, agency.getEmployees().get(PositionInTheCompany.ACCOUNTANT));
    }

    @Test
    void deleteEmployee() {
        RealEstateAgency agency = new RealEstateAgency();
        AgencyEmployee employee = new AgencyEmployee();

        employee.setPosition(PositionInTheCompany.ACCOUNTANT);
        agency.addPositionEmployees(PositionInTheCompany.ACCOUNTANT, employee);

        List<AgencyEmployee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        assertEquals(employeeList, agency.getEmployees().get(PositionInTheCompany.ACCOUNTANT));

        agency.deleteEmployee(employee);

        assertTrue(agency.getEmployees().get(PositionInTheCompany.ACCOUNTANT).isEmpty());
    }

    @Test
    void equalsAndHashCode() {
        RealEstateAgency agency1 = new RealEstateAgency();
        RealEstateAgency agency2 = new RealEstateAgency();
        RealEstateAgency agency3 = new RealEstateAgency();
        RealEstate realEstate = new RealEstate();
        Client client = new Client();

        agency1.addAvailableRealEstate(realEstate);
        agency1.addClient(client);

        agency2.addAvailableRealEstate(realEstate);
        agency2.addClient(client);

        assertEquals(agency2, agency1);
        assertNotEquals(agency3, agency1);
        assertEquals(agency2.hashCode(), agency1.hashCode());
        assertNotEquals(agency3.hashCode(), agency1.hashCode());
    }

    @Test
    void toStringTest() {
        RealEstateAgency agency = new RealEstateAgency();
        RealEstate realEstate = new RealEstate();
        Client client = new Client();

        agency.addAvailableRealEstate(realEstate);
        agency.addClient(client);

        String expectedToString = "RealEstateAgency{" +
                "availableRealEstate=" + agency.getAvailableRealEstate() +
                ", clients=" + agency.getClients() +
                '}';
        assertEquals(expectedToString, agency.toString());
    }
}