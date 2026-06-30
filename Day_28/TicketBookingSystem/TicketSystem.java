import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Ticket {
    private String seatNumber;
    private String category;
    private double price;
    private boolean isBooked;

    public Ticket(String seatNumber, String category, double price) {
        this.seatNumber = seatNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }

    public String getSeatNumber() { return seatNumber; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isBooked() { return isBooked; }

    public void setBooked(boolean booked) { this.isBooked = booked; }

    @Override
    public String toString() {
        String status = isBooked ? "[ BOOKED ]" : "[AVAILABLE]";
        return "Seat " + seatNumber + " (" + category + ") - $" + String.format("%.2f", price) + " " + status;
    }
}

class BookingSystem {
    private List<Ticket> seatInventory;

    public BookingSystem() {
        this.seatInventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
       
        for (int i = 1; i <= 5; i++) {
            seatInventory.add(new Ticket("A" + i, "VIP Row", 150.00));
        }
      
        for (int i = 1; i <= 5; i++) {
            seatInventory.add(new Ticket("B" + i, "Standard Row", 75.00));
        }
    }

    public void displaySeats() {
        System.out.println("\n--- Current Seat Map ---");
        for (Ticket seat : seatInventory) {
            System.out.println(seat);
        }
    }

    public void bookTicket(String seatNumber) {
        for (Ticket seat : seatInventory) {
            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)) {
                if (seat.isBooked()) {
                    System.out.println("Error: Sorry, seat " + seatNumber + " is already taken!");
                } else {
                    seat.setBooked(true);
                    System.out.println("Success! You have successfully booked " + seatNumber + ".");
                    System.out.println("Receipt Amount: $" + String.format("%.2f", seat.getPrice()));
                }
                return;
            }
        }
        System.out.println("Error: Seat " + seatNumber + " does not exist in our system map.");
    }

    public void cancelTicket(String seatNumber) {
        for (Ticket seat : seatInventory) {
            if (seat.getSeatNumber().equalsIgnoreCase(seatNumber)) {
                if (!seat.isBooked()) {
                    System.out.println("Warning: This seat is not currently active or booked.");
                } else {
                    seat.setBooked(false);
                    System.out.println("Success: Reservation for seat " + seatNumber + " has been cancelled.");
                }
                return;
            }
        }
        System.out.println("Error: Seat reference identifier not found.");
    }

    public void displayRevenueSummary() {
        double totalRevenue = 0;
        int soldCount = 0;
        
        for (Ticket seat : seatInventory) {
            if (seat.isBooked()) {
                totalRevenue += seat.getPrice();
                soldCount++;
            }
        }
        
        System.out.println("\n--- Live Business Summary ---");
        System.out.println("Total Tickets Sold  : " + soldCount + " / " + seatInventory.size());
        System.out.println("Gross Ticket Revenue: $" + String.format("%.2f", totalRevenue));
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("     METRO BOX OFFICE SYSTEM     ");
            System.out.println("=================================");
            System.out.println("1. View Available & Booked Seats");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Cancel a Ticket Booking");
            System.out.println("4. Check Total Revenue & Sales");
            System.out.println("5. Exit Box Office");
            System.out.print("Select action (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displaySeats();
                    break;

                case 2:
                    System.out.print("Enter Seat ID to reserve (e.g., A1, B3): ");
                    String targetSeat = scanner.nextLine().trim();
                    system.bookTicket(targetSeat);
                    break;

                case 3:
                    System.out.print("Enter Seat ID to cancel: ");
                    String cancelSeat = scanner.nextLine().trim();
                    system.cancelTicket(cancelSeat);
                    break;

                case 4:
                    system.displayRevenueSummary();
                    break;

                case 5:
                    System.out.println("Closing database connection... Have a great day at the show!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid selection! Please input an integer option from 1 to 5.");
            }
        }
    }
}
