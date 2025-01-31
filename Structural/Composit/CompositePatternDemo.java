package Composit;

import java.util.ArrayList;

// Step 1: Define the Component interface
interface Employee {
    void showDetails();
}

// Step 2: Implement the Leaf class (Individual Employee)
class Developer implements Employee {
    private String name;
    private String role;

    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Role: " + role);
    }
}

class Manager implements Employee {
    private String name;
    private String role;

    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + ", Role: " + role);
    }
}

// Step 3: Implement the Composite class (Department)
class Department implements Employee {
    private String departmentName;
    private List<Employee> employees = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }
}

// Step 4: Demonstrate the Composite Pattern
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create individual employees (Leaf objects)
        Employee dev1 = new Developer("John", "Java Developer");
        Employee dev2 = new Developer("Alice", "Frontend Developer");
        Employee manager1 = new Manager("Bob", "Engineering Manager");

        // Create departments (Composite objects)
        Department engineeringDepartment = new Department("Engineering");
        engineeringDepartment.addEmployee(dev1);
        engineeringDepartment.addEmployee(dev2);
        engineeringDepartment.addEmployee(manager1);

        // Create another individual employee
        Employee dev3 = new Developer("Tom", "Android Developer");

        // Create a higher level department (Composite object)
        Department company = new Department("Tech Company");
        company.addEmployee(engineeringDepartment);
        company.addEmployee(dev3);

        // Show details of the company structure
        company.showDetails();
    }
}
