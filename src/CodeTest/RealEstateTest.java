package CodeTest;

import Code.RealEstate;
import Code.RealEstateCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RealEstateTest {
    @Test
    void testSetAndGetAddress() {
        RealEstate realEstate = new RealEstate();
        realEstate.setAddress("123 Main Street");
        assertEquals("123 Main Street", realEstate.getAddress());
    }

    @Test
    void testSetAndGetArea() {
        RealEstate realEstate = new RealEstate();
        realEstate.setArea(100.0);
        assertEquals(100.0, realEstate.getArea(), 0.01);
    }

    @Test
    void testSetAreaWithInvalidValue() {
        RealEstate realEstate = new RealEstate();
        assertThrows(IllegalArgumentException.class, () -> realEstate.setArea(0.5));
    }

    @Test
    void testSetAndGetNumberOfRooms() {
        RealEstate realEstate = new RealEstate();
        realEstate.setNumberOfRooms(3);
        assertEquals(3, realEstate.getNumberOfRooms());
    }

    @Test
    void testSetNumberOfRoomsWithInvalidValue() {
        RealEstate realEstate = new RealEstate();
        assertThrows(IllegalArgumentException.class, () -> realEstate.setNumberOfRooms(0));
    }

    @Test
    void testSetAndGetRealEstateCategory() {
        RealEstate realEstate = new RealEstate();
        realEstate.setRealEstateCategory(RealEstateCategory.COMMERCIAL);
        assertEquals(RealEstateCategory.COMMERCIAL, realEstate.getRealEstateCategory());
    }

    @Test
    void testEqualsAndHashCode() {
        RealEstate realEstate1 = new RealEstate();
        realEstate1.setAddress("123 Main Street");
        realEstate1.setArea(100.0);
        realEstate1.setNumberOfRooms(3);
        realEstate1.setRealEstateCategory(RealEstateCategory.ENGINEERING_STRUCTURES);

        RealEstate realEstate2 = new RealEstate();
        realEstate2.setAddress("123 Main Street");
        realEstate2.setArea(100.0);
        realEstate2.setNumberOfRooms(3);
        realEstate2.setRealEstateCategory(RealEstateCategory.ENGINEERING_STRUCTURES);

        assertEquals(realEstate1, realEstate2);
        assertEquals(realEstate1.hashCode(), realEstate2.hashCode());
    }

    @Test
    void testToString() {
        RealEstate realEstate = new RealEstate();
        realEstate.setAddress("123 Main Street");
        realEstate.setArea(100.0);
        realEstate.setNumberOfRooms(3);
        realEstate.setRealEstateCategory(RealEstateCategory.ENGINEERING_STRUCTURES);

        String expectedToString = "RealEstate{address='123 Main Street', area=100.0, numberOfRooms=3, realEstateCategory=ENGINEERING_STRUCTURES}";
        assertEquals(expectedToString, realEstate.toString());
    }
}