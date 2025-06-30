import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Booking Details");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    hotel.searchAvailableRooms(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    String category = sc.nextLine();
                    System.out.print("Check-in date: ");
                    String checkIn = sc.nextLine();
                    System.out.print("Check-out date: ");
                    String checkOut = sc.nextLine();
                    hotel.bookRoom(name, category, checkIn, checkOut);
                }
                case 3 -> {
                    System.out.print("Enter Reservation ID: ");
                    hotel.cancelReservation(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter Reservation ID: ");
                    hotel.viewBookingDetails(sc.nextLine());
                }
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 0);

        sc.close();
    }
}
