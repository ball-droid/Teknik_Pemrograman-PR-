package id.ac.polban.main;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import id.ac.polban.service.EmployeeService;

public class MainApp {

    public static void main(String[] args) {
        Department it = new Department("IT");
        Department hr = new Department("HR");

        Employee e1 = new Employee("Andi", it, new EmploymentType("FULL_TIME"), 600000);
        Employee e2 = new Employee("Budi", hr, new EmploymentType("PART_TIME"), 300000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(e1);
        service.addEmployee(e2);

        printEmployee(service.getEmployee(e1.getId()));
        printEmployee(service.getEmployee(e2.getId()));
    }

    private static void printEmployee(Employee emp) {
        if (emp == null) {
            return;
        }

        System.out.println(
                "ID: " + emp.getId()
                + ", Name: " + emp.getName()
                + ", Dept: " + emp.getDepartment().getName()
                + ", Type: " + emp.getType().getType()
                + ", Salary: " + emp.getSalary());
    }
}
