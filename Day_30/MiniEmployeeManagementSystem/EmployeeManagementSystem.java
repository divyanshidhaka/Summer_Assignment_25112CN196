import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeManagementSystem {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        employeeList.add(new Employee(101, "Alice Smith", "HR", 55000));
        employeeList.add(new Employee(102, "Bob Jones", "IT", 75000));

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> updateEmployee();
                case 4 -> deleteEmployee();
                case 5 -> {
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        if (findEmployeeById(id) != null) {
            System.out.println("Error: An employee with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employeeList.add(new Employee(id, name, dept, salary));
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n---------------- Current Employee Records ----------------");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println("----------------------------------------------------------");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter new Name (Leave blank to keep '" + emp.getName() + "'): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) emp.setName(name);

        System.out.print("Enter new Department (Leave blank to keep '" + emp.getDepartment() + "'): ");
        String dept = scanner.nextLine();
        if (!dept.trim().isEmpty()) emp.setDepartment(dept);

        System.out.print("Enter new Salary (Enter -1 to keep '" + emp.getSalary() + "'): ");
        double salary = scanner.nextDouble();
        if (salary >= 0) emp.setSalary(salary);

        System.out.println("Employee updated successfully!");
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        Employee emp = findEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found.");
            return;
        }

        employeeList.remove(emp);
        System.out.println("Employee record deleted successfully!");
    }

    private static Employee findEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}