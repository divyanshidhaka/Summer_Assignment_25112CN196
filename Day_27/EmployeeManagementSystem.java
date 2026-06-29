import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Employee {
    private String id;
    private String name;
    private String department;
    private double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-20s | Dept: %-15s | Salary: $%,.2f", 
                id, name, department, salary);
    }
}

public class EmployeeManagementSystem {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        employeeList.add(new Employee("E101", "Alice Smith", "HR", 65000));
        employeeList.add(new Employee("E102", "Bob Jones", "Engineering", 95000));

        int choice = 0;

        while (choice != 6) {
            System.out.println("\n=========================================");
            System.out.println("       EMPLOYEE MANAGEMENT SYSTEM        ");
            System.out.println("=========================================");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Information");
            System.out.println("5. Remove Employee Record");
            System.out.println("6. Exit System");
            System.out.print("Enter choice (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateEmployee();
                case 5 -> removeEmployee();
                case 6 -> System.out.println("Shutting down management system. Goodbye!");
                default -> System.out.println("Invalid choice. Please select from options 1-6.");
            }
        }
        scanner.close();
    }

    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter Employee ID (e.g., E103): ");
        String id = scanner.nextLine().trim();

        if (findEmployeeById(id) != null) {
            System.out.println("Error: Employee ID " + id + " already exists in the system.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();

        System.out.print("Enter Annual Salary: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Salary must be a valid numeric amount.");
            scanner.next();
            return;
        }
        double salary = scanner.nextDouble();
        if (salary < 0) {
            System.out.println("Error: Salary cannot be negative.");
            return;
        }

        employeeList.add(new Employee(id, name, department, salary));
        System.out.println("Success: Record saved for " + name);
    }

    private static void displayEmployees() {
        System.out.println("\n--- Corporate Directory ---");
        if (employeeList.isEmpty()) {
            System.out.println("No records found in the system database.");
            return;
        }
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    private static void searchEmployee() {
        System.out.println("\n--- Search Directory ---");
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine().trim();

        Employee emp = findEmployeeById(id);
        if (emp != null) {
            System.out.println("Record Details Found:");
            System.out.println(emp);
        } else {
            System.out.println("No matching employee profile associated with ID: " + id);
        }
    }

    private static void updateEmployee() {
        System.out.println("\n--- Update Profile Info ---");
        System.out.print("Enter Employee ID to update: ");
        String id = scanner.nextLine().trim();

        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("Target record not found.");
            return;
        }

        System.out.println("Current profile: " + emp);
        System.out.print("Enter new Name (or press Enter to keep current): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) emp.setName(name);

        System.out.print("Enter new Department (or press Enter to keep current): ");
        String department = scanner.nextLine().trim();
        if (!department.isEmpty()) emp.setDepartment(department);

        System.out.print("Enter new Salary (or enter -1 to keep current): ");
        if (scanner.hasNextDouble()) {
            double salary = scanner.nextDouble();
            if (salary >= 0) emp.setSalary(salary);
        } else {
            scanner.next();
        }
        
        System.out.println("Success: Employee record modified successfully.");
    }

    private static void removeEmployee() {
        System.out.println("\n--- Decommission Record ---");
        System.out.print("Enter Employee ID to delete: ");
        String id = scanner.nextLine().trim();

        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("Success: Record for ID " + id + " has been purged safely.");
        } else {
            System.out.println("Deletion Blocked: No matching record found.");
        }
    }

    private static Employee findEmployeeById(String id) {
        for (Employee emp : employeeList) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }
}