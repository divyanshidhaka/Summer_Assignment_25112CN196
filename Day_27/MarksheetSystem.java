import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentMarksheet {
    private String rollNumber;
    private String studentName;
    private int[] marks;
    private String[] subjectNames = {"Mathematics", "Physics", "Chemistry", "English", "Computer Science"};

    public StudentMarksheet(String rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    public String getRollNumber() { return rollNumber; }
    public String getName() { return studentName; }

    public int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculatePercentage() {
        return (calculateTotal() / 500.0) * 100;
    }

    public String evaluateStatus() {
        for (int mark : marks) {
            if (mark < 33) {
                return "FAIL (Failed in 1 or more subjects)";
            }
        }
        return "PASS";
    }

    public String calculateGrade() {
        if (evaluateStatus().startsWith("FAIL")) return "F";
        
        double percentage = calculatePercentage();
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        if (percentage >= 33) return "E";
        return "F";
    }

    public void printReportCard() {
        System.out.println("\n==================================================");
        System.out.println("            ACADEMIC MARKSHEET REPORT             ");
        System.out.println("==================================================");
        System.out.printf("Roll Number  : %-15s\n", rollNumber);
        System.out.printf("Student Name : %-30s\n", studentName);
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s | %-10s | %-10s\n", "SUBJECT NAME", "MAX MARKS", "OBTAINED");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-25s | %-10d | %-10d\n", subjectNames[i], 100, marks[i]);
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL MARKS OBTAINED : %d / 500\n", calculateTotal());
        System.out.printf("AGGREGATE PERCENTAGE : %.2f%%\n", calculatePercentage());
        System.out.printf("FINAL LETTER GRADE   : %s\n", calculateGrade());
        System.out.printf("RESULT STATUS        : %s\n", evaluateStatus());
        System.out.println("==================================================");
    }
}

public class MarksheetSystem {
    private static final List<StudentMarksheet> database = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        database.add(new StudentMarksheet("R001", "Emma Watson", new int[]{85, 92, 78, 88, 95}));
        database.add(new StudentMarksheet("R002", "Ron Weasley", new int[]{45, 32, 55, 60, 50})); // Fails Physics

        int choice = 0;
        while (choice != 4) {
            System.out.println("\n=== MARKSHEET GENERATION SYSTEM ===");
            System.out.println("1. Enter Student Scores");
            System.out.println("2. Generate Student Marksheet (Print Report)");
            System.out.println("3. Display Class Performance Overview");
            System.out.println("4. Exit System");
            System.out.print("Select operation (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> collectStudentData();
                case 2 -> generateSingleReport();
                case 3 -> displayClassOverview();
                case 4 -> System.out.println("Shutting down transcript module. System offline.");
                default -> System.out.println("Invalid choice. Please select options from 1 to 4.");
            }
        }
        scanner.close();
    }

    private static void collectStudentData() {
        System.out.println("\n--- Data Entry Sheet ---");
        System.out.print("Enter unique Roll Number: ");
        String roll = scanner.nextLine().trim();

        if (findRecord(roll) != null) {
            System.out.println("Error: Marksheet configurations already exist for Roll No: " + roll);
            return;
        }

        System.out.print("Enter Student Full Name: ");
        String name = scanner.nextLine().trim();

        int[] inputMarks = new int[5];
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "English", "Computer Science"};

        System.out.println("Enter individual subject marks (Score out of 100):");
        for (int i = 0; i < 5; i++) {
            while (true) {
                System.out.print("  " + subjects[i] + ": ");
                if (scanner.hasNextInt()) {
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        inputMarks[i] = mark;
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("    Invalid score! Marks must be a whole number between 0 and 100.");
            }
        }
        scanner.nextLine();

        database.add(new StudentMarksheet(roll, name, inputMarks));
        System.out.println("Success: Performance matrices logged securely.");
    }

    private static void generateSingleReport() {
        System.out.print("\nEnter Roll Number to compile transcript: ");
        String roll = scanner.nextLine().trim();
        StudentMarksheet record = findRecord(roll);

        if (record != null) {
            record.printReportCard();
        } else {
            System.out.println("Error: Student record mismatch.");
        }
    }

    private static void displayClassOverview() {
        System.out.println("\n--- General Classroom Performance Ledger ---");
        if (database.isEmpty()) {
            System.out.println("No entries processed yet.");
            return;
        }

        System.out.printf("%-10s | %-20s | %-12s | %-12s | %-6s\n", "Roll No", "Student Name", "Total (/500)", "Percentage", "Grade");
        System.out.println("-------------------------------------------------------------------------");
        for (StudentMarksheet s : database) {
            System.out.printf("%-10s | %-20s | %-12d | %-11.2f%% | %-6s\n",
                    s.getRollNumber(), s.getName() == null ? "" : s.getName(), s.calculateTotal(), s.calculatePercentage(), s.calculateGrade());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    private static StudentMarksheet findRecord(String roll) {
        for (StudentMarksheet s : database) {
            if (s.getRollNumber().equalsIgnoreCase(roll)) return s;
        }
        return null;
    }
}