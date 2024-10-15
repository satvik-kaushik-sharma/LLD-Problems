package Employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int employeeId;
    List<Employee> managed = new ArrayList<Employee>();

    public List<Employee> getManaged() {
        return managed;
    }

    public Employee(int id) {
        this.employeeId = id;
    }
}
