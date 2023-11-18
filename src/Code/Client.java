package Code;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client extends Person {
    private Long id;
    private Set<RealEstate> realEstates;
    private String email;
    private String phoneNumber;
    private BigDecimal wallet;

    public Set<RealEstate> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(Set<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(String money) {
        this.wallet = new BigDecimal(money);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
            return;
        }
        throw new IllegalArgumentException("Incorrect email");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.phoneNumber = phoneNumber;
            return;
        }
        throw new IllegalArgumentException("Incorrect phone number");

    }

    public boolean addRealEstate(RealEstate realEstate) {
        if (realEstates.contains(realEstate)) {
            return false;
        }
        realEstates.add(realEstate);
        return true;
    }

    public boolean deleteRealEstate(RealEstate realEstate) {
        if (realEstates.contains(realEstate)) {
            realEstates.remove(realEstate);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(realEstates, client.realEstates) && Objects.equals(email, client.email) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(wallet, client.wallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, realEstates, email, phoneNumber, wallet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", realEstates=" + realEstates +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", wallet=" + wallet +
                "} " + super.toString();
    }
}
