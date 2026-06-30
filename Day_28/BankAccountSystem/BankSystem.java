import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        
        addTransaction("Account opened with an initial balance of $" + String.format("%.2f", initialDeposit));
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }

    // Core Banking Operations
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: $" + String.format("%.2f", amount));
            System.out.println("Success: $" + String.format("%.2f", amount) + " deposited successfully.");
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient funds. Current balance: $" + String.format("%.2f", balance));
            return false;
        }
        
        balance -= amount;
        addTransaction("Withdrew: $" + String.format("%.2f", amount));
        System.out.println("Success: Please collect your cash: $" + String.format("%.2f", amount));
        return true;
    }

    private void addTransaction(String message) {
        transactionHistory.add(message);
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction Statement for Account: " + accountNumber + " ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No recorded transactions found.");
            return;
        }
        for (String record : transactionHistory) {
            System.out.println("- " + record);
        }
    }
}

class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String name, double initialDeposit) {

        String newAccNum = "ACC" + (1001 + accounts.size());
        BankAccount account = new BankAccount(newAccNum, name, initialDeposit);
        accounts.add(account);
        System.out.println("\nSuccess! Account created for " + name);
        System.out.println("Your assigned Account Number is: " + newAccNum);
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void transferMoney(String senderAccNum, String receiverAccNum, double amount) {
        BankAccount sender = findAccount(senderAccNum);
        BankAccount receiver = findAccount(receiverAccNum);

        if (sender == null) {
            System.out.println("Error: Sender account not found.");
            return;
        }
        if (receiver == null) {
            System.out.println("Error: Receiver account not found.");
            return;
        }

        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Transfer Complete: successfully moved $" + String.format("%.2f", amount) + " to " + receiver.getAccountHolderName());
        }
    }
}


public class BankSystem {
    public static void main(String[] args) {
        Bank chase = new Bank();
        Scanner scanner = new Scanner(System.in);

        chase.createAccount("Alice Smith", 500.00); // Gets ACC1001
        chase.createAccount("Bob Jones", 150.00);   // Gets ACC1002

        while (true) {
            System.out.println("\n=================================");
            System.out.println("     GLOBAL SECURITY BANK        ");
            System.out.println("=================================");
            System.out.println("1. Create New Bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Summary & Balance");
            System.out.println("6. Print Transaction Statement");
            System.out.println("7. Exit System");
            System.out.print("Choose an option (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter full name of account holder: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial opening deposit amount: $");
                    double openingBalance = scanner.nextDouble();
                    chase.createAccount(name, openingBalance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAccNum = scanner.nextLine();
                    BankAccount depAcc = chase.findAccount(depAccNum);
                    if (depAcc != null) {
                        System.out.print("Enter amount to deposit: $");
                        double amount = scanner.nextDouble();
                        depAcc.deposit(amount);
                    } else {
                        System.out.println("Error: Account code not recognized.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String witAccNum = scanner.nextLine();
                    BankAccount witAcc = chase.findAccount(witAccNum);
                    if (witAcc != null) {
                        System.out.print("Enter amount to withdraw: $");
                        double amount = scanner.nextDouble();
                        witAcc.withdraw(amount);
                    } else {
                        System.out.println("Error: Account code not recognized.");
                    }
                    break;

                case 4:
                    System.out.print("Enter YOUR Account Number (Sender): ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("Enter TARGET Account Number (Recipient): ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Enter transfer amount: $");
                    double xferAmount = scanner.nextDouble();
                    chase.transferMoney(fromAcc, toAcc, xferAmount);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String checkAccNum = scanner.nextLine();
                    BankAccount checkAcc = chase.findAccount(checkAccNum);
                    if (checkAcc != null) {
                        checkAcc.displayAccountSummary();
                    } else {
                        System.out.println("Error: Account code not recognized.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    String historyAccNum = scanner.nextLine();
                    BankAccount historyAcc = chase.findAccount(historyAccNum);
                    if (historyAcc != null) {
                        historyAcc.displayTransactionHistory();
                    } else {
                        System.out.println("Error: Account code not recognized.");
                    }
                    break;

                case 7:
                    System.out.println("Logging out... Secure connection closed. Have a nice day!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid input selection. Choose options between 1 and 7.");
            }
        }
    }
}