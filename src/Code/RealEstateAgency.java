package Code;

import java.util.Objects;
import java.util.Set;

public class RealEstateAgency {
    private Set<RealEstate> availableRealEstate;
    private Set<Client> clients;

    public Set<RealEstate> getAvailableRealEstate() {
        return availableRealEstate;
    }

    public void setAvailableRealEstate(Set<RealEstate> availableRealEstate) {
        this.availableRealEstate = availableRealEstate;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public boolean addAvailableRealEstate(RealEstate realEstate) {
        if (availableRealEstate.contains(realEstate)) {
            return false;
        }
        availableRealEstate.add(realEstate);
        return true;
    }

    public boolean deleteAvailableRealEstate(RealEstate realEstate) {
        if (availableRealEstate.contains(realEstate)) {
            availableRealEstate.remove(realEstate);
            return true;
        }
        return false;
    }

    public boolean addClient(Client client) {
        if (clients.contains(client)) {
            return false;
        }
        clients.add(client);
        return true;
    }

    public boolean deleteClient(Client client) {
        if (clients.contains(client)) {
            clients.remove(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstateAgency that = (RealEstateAgency) o;
        return Objects.equals(availableRealEstate, that.availableRealEstate) && Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableRealEstate, clients);
    }

    @Override
    public String toString() {
        return "RealEstateAgency{" +
                "availableRealEstate=" + availableRealEstate +
                ", clients=" + clients +
                '}';
    }
}
