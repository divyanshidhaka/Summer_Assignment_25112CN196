import java.util.Scanner;

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum capacity of the student database: ");
        int maxCapacity = scanner.nextInt();

        int[] rollNumbers = new int[maxCapacity];
        String[] names = new String[maxCapacity];
        String[] courses = new String[maxCapacity];
        
        int totalStudents = 0;
        while (true) {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. Display All Student Records");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student Course");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                System.out.println("Exiting Student Record System. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    if (totalStudents >= maxCapacity) {
                        System.out.println("Error: Database capacity reached! Cannot add more students.");
                    } else {
                        System.out.print("Enter Roll Number (Integer): ");
                        int roll = scanner.nextInt();
                        scanner.nextLine();

                        boolean duplicate = false;
                        for (int i = 0; i < totalStudents; i++) {
                            if (rollNumbers[i] == roll) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (duplicate) {
                            System.out.println("Error: A student with Roll Number " + roll + " already exists.");
                        } else {
                            rollNumbers[totalStudents] = roll;

                            System.out.print("Enter Student Name: ");
                            names[totalStudents] = scanner.nextLine();

                            System.out.print("Enter Course Name: ");
                            courses[totalStudents] = scanner.nextLine();

                            totalStudents++;
                            System.out.println("Student record added successfully!");
                        }
                    }
                    break;

                case 2:
                    if (totalStudents == 0) {
                        System.out.println("No records found. The database is empty.");
                    } else {
                        System.out.println("\n---------------- STUDENT DATABASE ----------------");
                        System.out.printf("%-12s | %-20s | %-15s\n", "Roll No", "Name", "Course");
                        System.out.println("--------------------------------------------------");
                        for (int i = 0; i < totalStudents; i++) {
                            System.out.printf("%-12d | %-20s | %-15s\n", rollNumbers[i], names[i], courses[i]);
                        }
                        System.out.println("--------------------------------------------------");
                    }
                    break;

                case 3: // SEARCH RECORD
                    if (totalStudents == 0) {
                        System.out.println("The database is empty.");
                    } else {
                        System.out.print("Enter Roll Number to search: ");
                        int searchRoll = scanner.nextInt();
                        int foundIndex = -1;

                        for (int i = 0; i < totalStudents; i++) {
                            if (rollNumbers[i] == searchRoll) {
                                foundIndex = i;
                                break;
                            }
                        }

                        if (foundIndex == -1) {
                            System.out.println("Record not found for Roll Number: " + searchRoll);
                        } else {
                            System.out.println("\nRecord Found:");
                            System.out.println("Roll Number : " + rollNumbers[foundIndex]);
                            System.out.println("Name        : " + names[foundIndex]);
                            System.out.println("Course      : " + courses[foundIndex]);
                        }
                    }
                    break;

                case 4: 
                    if (totalStudents == 0) {
                        System.out.println("The database is empty.");
                    } else {
                        System.out.print("Enter Roll Number to update course: ");
                        int updateRoll = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        int updateIndex = -1;
                        for (int i = 0; i < totalStudents; i++) {
                            if (rollNumbers[i] == updateRoll) {
                                updateIndex = i;
                                break;
                            }
                        }

                        if (updateIndex == -1) {
                            System.out.println("Record not found for Roll Number: " + updateRoll);
                        } else {
                            System.out.println("Current course for " + names[updateIndex] + " is: " + courses[updateIndex]);
                            System.out.print("Enter new course: ");
                            courses[updateIndex] = scanner.nextLine();
                            System.out.println("Course updated successfully!");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid selection. Please input a number from 1 to 5.");
            }
        }
        scanner.close();
    }
}