package Code;

import java.util.Objects;

public class RealEstate {
    private String address;
    private double area;
    private int numberOfRooms;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 1) {
            throw new IllegalArgumentException("The area cannot be less than 1");
        }
        this.area = area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms < 1) {
            throw new IllegalArgumentException("Rooms cannot be less than 1");
        }
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return Double.compare(area, that.area) == 0 && numberOfRooms == that.numberOfRooms && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, area, numberOfRooms);
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }
}
