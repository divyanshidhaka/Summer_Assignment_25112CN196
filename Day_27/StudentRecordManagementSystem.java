import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    public void setName(String name) { this.name = name; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-20s | GPA: %.2f", id, name, gpa);
    }
}

public class StudentRecordManagementSystem {
    private static final List<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n=== STUDENT RECORD MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Please select from options 1-5.");
            }
        }
        scanner.close();
    }

    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter unique Student ID: ");
        String id = scanner.nextLine().trim();

        if (findStudentById(id) != null) {
            System.out.println("Error: A student with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter GPA (0.0 - 4.0): ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: GPA must be a decimal number.");
            scanner.next();
            return;
        }
        double gpa = scanner.nextDouble();
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("Error: GPA must be strictly between 0.0 and 4.0.");
            return;
        }

        studentList.add(new Student(id, name, gpa));
        System.out.println("Success: Student record saved successfully!");
    }

    private static void displayStudents() {
        System.out.println("\n--- Student Database Records ---");
        if (studentList.isEmpty()) {
            System.out.println("The student database is currently empty.");
            return;
        }
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        System.out.print("Enter Student ID to look up: ");
        String id = scanner.nextLine().trim();

        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Record Found:");
            System.out.println(student);
        } else {
            System.out.println("No matching record found for ID: " + id);
        }
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student Record ---");
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine().trim();

        Student student = findStudentById(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Success: Student record with ID " + id + " has been completely removed.");
        } else {
            System.out.println("Deletion Failed: No record exists for ID: " + id);
        }
    }

    private static Student findStudentById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}