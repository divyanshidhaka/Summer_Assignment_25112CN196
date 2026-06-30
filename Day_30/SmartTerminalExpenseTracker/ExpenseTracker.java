import java.util.Scanner;

public class ExpenseTracker {
  
    private static final int MAX_EXPENSES = 100;
    
    private static final double[] amounts = new double[MAX_EXPENSES];
    private static final String[] categories = new String[MAX_EXPENSES];
    private static final String[] notes = new String[MAX_EXPENSES];
 
    private static int expenseCount = 0; 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedInitialData();

        while (true) {
            System.out.println("\n===== SMART TERMINAL EXPENSE TRACKER =====");
            System.out.println("1. Log a New Expense");
            System.out.println("2. Display All Logged Expenses");
            System.out.println("3. Show Financial Insights (Total, Avg, Max)");
            System.out.println("4. Filter Expenses by Category");
            System.out.println("5. Exit");
            System.out.print("Select an operation (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid Input! Please type a number between 1 and 5.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> logNewExpense();
                case 2 -> displayAllExpenses();
                case 3 -> displayInsights();
                case 4 -> filterByCategory();
                case 5 -> {
                    System.out.println("Exiting System. Stay on budget!");
                    System.exit(0);
                }
                default -> System.out.println("Option out of bounds. Select a number from 1 to 5.");
            }
        }
    }

    private static void seedInitialData() {
        addExpenseRecord(14.80, "Food", "Lunch at diner");
        addExpenseRecord(45.00, "Transport", "Gas station filling");
        addExpenseRecord(12.50, "Food", "Evening Coffee Run");
        addExpenseRecord(115.00, "Entertainment", "Concert booking ticket");
    }

    private static void addExpenseRecord(double amount, String category, String note) {
        if (expenseCount < MAX_EXPENSES) {
            amounts[expenseCount] = amount;
            categories[expenseCount] = category;
            notes[expenseCount] = note;
            expenseCount++;
        } else {
            System.out.println("System Alert: Data limits reached. Delete or clear data to log more.");
        }
    }

    private static void logNewExpense() {
        if (expenseCount >= MAX_EXPENSES) {
            System.out.println("Error: System memory capacity full.");
            return;
        }

        System.out.print("Enter payment amount ($): ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid format. Enter a numerical decimal value: $");
            scanner.nextLine();
        }
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter budget category (e.g., Food, Transport, Rent): ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) {
            category = "Uncategorized";
        }

        System.out.print("Enter an optional contextual description/note: ");
        String note = scanner.nextLine().trim();
        if (note.isEmpty()) {
            note = "None";
        }

        addExpenseRecord(amount, category, note);
        System.out.println("Success: Transaction mapped and logged.");
    }

    private static void displayAllExpenses() {
        if (expenseCount == 0) {
            System.out.println("Database empty. Try logging an expense item first.");
            return;
        }

        System.out.println("\n------------------------- ALL REGISTERED TRANSACTIONS -------------------------");
        for (int i = 0; i < expenseCount; i++) {
            System.out.printf("Log ID: #%-3d | Amount: $%-7.2f | Category: %-14s | Description: %s\n", 
                    (i + 1), amounts[i], categories[i], notes[i]);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void displayInsights() {
        if (expenseCount == 0) {
            System.out.println("No transactional metrics logged to calculate insights.");
            return;
        }

        double aggregateSum = 0;
        double maxTransaction = amounts[0];
        int maxIndex = 0;

        for (int i = 0; i < expenseCount; i++) {
            aggregateSum += amounts[i];
            
            if (amounts[i] > maxTransaction) {
                maxTransaction = amounts[i];
                maxIndex = i;
            }
        }

        double evaluationAverage = aggregateSum / expenseCount;

        System.out.println("\n====================== FINANCIAL PROFILE ANALYSIS ======================");
        System.out.printf("Aggregate Spend Outlay:   $%.2f\n", aggregateSum);
        System.out.printf("Average Per-Item Cost:    $%.2f\n", evaluationAverage);
        System.out.printf("Peak Individual Expense:  $%.2f [Category: %s | Item: '%s']\n", 
                maxTransaction, categories[maxIndex], notes[maxIndex]);
        System.out.println("========================================================================");
    }

    private static void filterByCategory() {
        if (expenseCount == 0) {
            System.out.println("No transaction details stored inside memory storage arrays.");
            return;
        }

        System.out.print("Search string for filtering categories: ");
        String query = scanner.nextLine().trim();
        boolean queryMatchTrigger = false;

        System.out.println("\n--- Query Matches for Category: \"" + query + "\" ---");
        for (int i = 0; i < expenseCount; i++) {
            if (categories[i].equalsIgnoreCase(query)) {
                System.out.printf("Transaction Value: $%-8.2f | Associated Log Info: %s\n", amounts[i], notes[i]);
                queryMatchTrigger = true;
            }
        }

        if (!queryMatchTrigger) {
            System.out.println("No matching categories detected matching \"" + query + "\"");
        }
        System.out.println("-----------------------------------------------------");
    }
}