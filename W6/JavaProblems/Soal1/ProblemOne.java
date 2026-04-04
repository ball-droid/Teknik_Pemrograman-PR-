package JavaProblems.Soal1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemOne {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("John", 50000));
        list.add(new Employee("Rob", 70000));
        list.add(new Employee("Bob", 40000));
        list.add(new Employee("Alice", 10000));

        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp = list.stream() // [1]
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName())) // [2] & [3]
                .collect(Collectors.toList()); // [4] & [5]w

        for (Employee e : sortedEmp) {
            System.out.println(e);
        }
    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter getName() — digunakan pada bagian [3]
    public String getName() {
        return name;
    }

    // Getter getSalary()
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}