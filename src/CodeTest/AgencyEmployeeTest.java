package CodeTest;

import Code.AgencyEmployee;
import Code.PositionInTheCompany;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgencyEmployeeTest {
    @Test
    void testSetAndGetSalary() {
        AgencyEmployee employee = new AgencyEmployee();
        employee.setSalary("10000.50");
        assertEquals(new BigDecimal("10000.50"), employee.getSalary());
    }

    @Test
    void testSetSalaryWithInvalidFormat() {
        AgencyEmployee employee = new AgencyEmployee();
        assertThrows(NumberFormatException.class, () -> employee.setSalary("invalidSalary"));
    }

    @Test
    void testSetAndGetPosition() {
        AgencyEmployee employee = new AgencyEmployee();
        employee.setPosition(PositionInTheCompany.REALTOR);
        assertEquals(PositionInTheCompany.REALTOR, employee.getPosition());
    }

    @Test
    void testEqualsAndHashCode() throws ParseException {
        AgencyEmployee employee1 = new AgencyEmployee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setDateOfBrith("2000-01-01");
        employee1.setPosition(PositionInTheCompany.REALTOR);
        employee1.setSalary("10000.50");

        AgencyEmployee employee2 = new AgencyEmployee();
        employee2.setFirstName("John");
        employee2.setLastName("Doe");
        employee2.setDateOfBrith("2000-01-01");
        employee2.setPosition(PositionInTheCompany.REALTOR);
        employee2.setSalary("10000.50");

        assertEquals(employee1, employee2);
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testToString() throws ParseException {
        AgencyEmployee employee = new AgencyEmployee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setDateOfBrith("2000-01-01");
        employee.setPosition(PositionInTheCompany.REALTOR);
        employee.setSalary("10000.50");

        String expectedToString = "AgencyEmployee{position=REALTOR, salary=10000.50} Person{firstName='John', lastName='Doe', dateOfBrith=Sat Jan 01 00:00:00 MSK 2000}";
        assertEquals(expectedToString, employee.toString());
    }
}