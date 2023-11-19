package Code;

import java.util.*;

public class RealEstateAgency {
    private Set<RealEstate> availableRealEstate;
    private Set<Client> clients;
    private Map<PositionInTheCompany, List<AgencyEmployee>> employees;

    public RealEstateAgency(){
        clients = new HashSet<>();
        availableRealEstate = new HashSet<>();
        employees = new HashMap<>();
    }


    public Map<PositionInTheCompany, List<AgencyEmployee>> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<PositionInTheCompany, List<AgencyEmployee>> employees) {
        this.employees = employees;
    }

    public void addPositionEmployees(PositionInTheCompany name, AgencyEmployee employee) {
        if (employee.getPosition() != name) {
            throw new IllegalArgumentException("invalid position!");
        }
        this.employees.put(name, null);
        List<AgencyEmployee> employeeList = employees.get(name);
        employeeList = new ArrayList<>();
        employees.put(name, employeeList);
        employeeList.add(employee);
    }

    public void deletePositionEmployees(PositionInTheCompany name) {
        employees.remove(name);
    }

    public void addEmployee(AgencyEmployee employee) {
        List<AgencyEmployee> employeeList = employees.get(employee.getPosition());
        employeeList.add(employee);
    }

    public void deleteEmployee(AgencyEmployee employee) {
        List<AgencyEmployee> employeeList = employees.get(employee.getPosition());
        employeeList.remove(employee);
    }

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
