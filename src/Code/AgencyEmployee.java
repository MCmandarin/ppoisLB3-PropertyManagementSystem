package Code;

import java.math.BigDecimal;
import java.util.Objects;

public class AgencyEmployee extends Person {
    private PositionInTheCompany position;
    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(String money) {
        this.salary = new BigDecimal(money);
    }

    public PositionInTheCompany getPosition() {
        return position;
    }

    public void setPosition(PositionInTheCompany position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AgencyEmployee that = (AgencyEmployee) o;
        return position == that.position && Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, salary);
    }

    @Override
    public String toString() {
        return "AgencyEmployee{" +
                "position=" + position +
                ", salary=" + salary +
                "} " + super.toString();
    }
}
