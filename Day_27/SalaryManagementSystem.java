import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PayrollEmployee {
    private String id;
    private String name;
    private double baseSalary;
    private double allowances;

   
    private static final double TAX_RATE = 0.12;
    private static final double PF_RATE = 0.05;

    public PayrollEmployee(String id, String name, double baseSalary, double allowances) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.allowances = allowances;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public double getAllowances() { return allowances; }

    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public void setAllowances(double allowances) { this.allowances = allowances; }


    public double calculateGrossSalary() {
        return baseSalary + allowances;
    }

    public double calculateTaxDeduction() {
        return calculateGrossSalary() * TAX_RATE;
    }

    public double calculatePFDeduction() {
        return calculateGrossSalary() * PF_RATE;
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - (calculateTaxDeduction() + calculatePFDeduction());
    }

    public void printPayslip() {
        System.out.println("\n=========================================");
        System.out.println("            OFFICIAL PAYSLIP             ");
        System.out.println("=========================================");
        System.out.printf("Employee ID   : %s\n", id);
        System.out.printf("Employee Name : %s\n", name);
        System.out.println("-----------------------------------------");
        System.out.printf("Base Salary   : $%,.2f\n", baseSalary);
        System.out.printf("Allowances    : $%,.2f\n", allowances);
        System.out.printf("GROSS SALARY  : $%,.2f\n", calculateGrossSalary());
        System.out.println("-----------------------------------------");
        System.out.printf("Deductions:\n");
        System.out.printf("  - Income Tax (12%%) : $%,.2f\n", calculateTaxDeduction());
        System.out.printf("  - Prov. Fund (5%%)  : $%,.2f\n", calculatePFDeduction());
        System.out.println("-----------------------------------------");
        System.out.printf("NET TAKE-HOME : $%,.2f\n", calculateNetSalary());
        System.out.println("=========================================");
    }
}

public class SalaryManagementSystem {
    private static final List<PayrollEmployee> payrollDb = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        payrollDb.add(new PayrollEmployee("EMP01", "John Doe", 5000.00, 800.00));
        payrollDb.add(new PayrollEmployee("EMP02", "Jane Smith", 7200.00, 1100.00));

        int choice = 0;
        while (choice != 5) {
            System.out.println("\n=== CORPORATE SALARY & PAYROLL SYSTEM ===");
            System.out.println("1. Add Employee Base Financials");
            System.out.println("2. Display Payroll Overview Table");
            System.out.println("3. Generate Specific Employee Payslip");
            System.out.println("4. Update Employee Base/Allowances");
            System.out.println("5. Exit System");
            System.out.print("Select operational task (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a choice number.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployeeFinancials();
                case 2 -> displayPayrollOverview();
                case 3 -> generatePayslip();
                case 4 -> updateFinancials();
                case 5 -> System.out.println("Exiting Payroll Module safely. System Offline.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void addEmployeeFinancials() {
        System.out.println("\n--- Onboard Employee Payroll ---");
        System.out.print("Enter unique Employee ID: ");
        String id = scanner.nextLine().trim();

        if (findEmployee(id) != null) {
            System.out.println("Error: Employee ID already configured in payroll system.");
            return;
        }

        System.out.print("Enter Employee Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Monthly Base Salary ($): ");
        double base = getValidDouble();
        
        System.out.print("Enter Monthly Allowances ($): ");
        double allowances = getValidDouble();

        payrollDb.add(new PayrollEmployee(id, name, base, allowances));
        System.out.println("Success: Corporate payroll profile securely saved!");
    }

    private static void displayPayrollOverview() {
        System.out.println("\n--- Corporate Payroll Overview Summary ---");
        if (payrollDb.isEmpty()) {
            System.out.println("No operational payroll sheets found.");
            return;
        }

        System.out.printf("%-8s | %-15s | %-12s | %-12s | %-12s\n", "ID", "Name", "Gross Pay", "Deductions", "Net Pay");
        System.out.println("----------------------------------------------------------------------------");
        
        double totalCompanyPayout = 0;
        for (PayrollEmployee emp : payrollDb) {
            double gross = emp.calculateGrossSalary();
            double totalDeductions = emp.calculateTaxDeduction() + emp.calculatePFDeduction();
            double net = emp.calculateNetSalary();
            totalCompanyPayout += net;

            System.out.printf("%-8s | %-15s | $%,-11.2f | $%,-11.2f | $%,-11.2f\n",
                    emp.getId(), emp.getName(), gross, totalDeductions, net);
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("Total Net Funds Disbursed this Cycle: $%,.2f\n", totalCompanyPayout);
    }

    private static void generatePayslip() {
        System.out.print("\nEnter Employee ID to issue payslip: ");
        String id = scanner.nextLine().trim();
        PayrollEmployee emp = findEmployee(id);

        if (emp != null) {
            emp.printPayslip();
        } else {
            System.out.println("Error: Record not found in active payroll ledger.");
        }
    }

    private static void updateFinancials() {
        System.out.print("\nEnter Employee ID to update payroll: ");
        String id = scanner.nextLine().trim();
        PayrollEmployee emp = findEmployee(id);

        if (emp == null) {
            System.out.println("Error: Employee record mismatch.");
            return;
        }

        System.out.print("Enter New Base Salary (or -1 to skip): ");
        double newBase = getValidDouble();
        if (newBase >= 0) emp.setBaseSalary(newBase);

        System.out.print("Enter New Allowances (or -1 to skip): ");
        double newAllowances = getValidDouble();
        if (newAllowances >= 0) emp.setAllowances(newAllowances);

        System.out.println("Success: Compensation structures adjusted.");
    }

    private static PayrollEmployee findEmployee(String id) {
        for (PayrollEmployee emp : payrollDb) {
            if (emp.getId().equalsIgnoreCase(id)) return emp;
        }
        return null;
    }

    private static double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid currency value. Enter numbers only: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}