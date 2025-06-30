import java.io.*;
import java.util.*;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private final String roomFile = "rooms.txt";
    private final String resFile = "reservations.txt";

    public Hotel() {
        loadRooms();
        loadReservations();
    }

    public void loadRooms() {
        try (BufferedReader br = new BufferedReader(new FileReader(roomFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                Room room = Room.fromString(line);
                rooms.add(room);
            }
        } catch (IOException e) {
            generateSampleRooms(); // If file not found
        }
    }

    public void generateSampleRooms() {
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3500));
        rooms.add(new Room(103, "Suite", 5000));
        saveRooms();
    }

    public void saveRooms() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(roomFile))) {
            for (Room r : rooms) {
                pw.println(r.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving rooms.");
        }
    }

    public void loadReservations() {
        try (BufferedReader br = new BufferedReader(new FileReader(resFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                reservations.add(Reservation.fromString(line));
            }
        } catch (IOException ignored) {}
    }

    public void saveReservations() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(resFile))) {
            for (Reservation r : reservations) {
                pw.println(r.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving reservations.");
        }
    }

    public void searchAvailableRooms(String category) {
        System.out.println("\nAvailable Rooms (" + category + "):");
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                System.out.println("Room " + r.getRoomNumber() + " - ₹" + r.getPricePerNight());
            }
        }
    }

    public boolean bookRoom(String name, String category, String checkIn, String checkOut) {
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                r.setAvailable(false);
                double totalCost = r.getPricePerNight(); // Simplified
                Reservation res = new Reservation(name, r.getRoomNumber(), checkIn, checkOut, totalCost);
                reservations.add(res);
                saveRooms();
                saveReservations();
                System.out.println("Booking successful! Reservation ID: " + res.getReservationId());
                simulatePayment(totalCost);
                return true;
            }
        }
        System.out.println("No available rooms in this category.");
        return false;
    }

    public boolean cancelReservation(String resId) {
        Iterator<Reservation> it = reservations.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getReservationId().equals(resId)) {
                for (Room room : rooms) {
                    if (room.getRoomNumber() == r.getRoomNumber()) {
                        room.setAvailable(true);
                    }
                }
                it.remove();
                saveRooms();
                saveReservations();
                System.out.println("Reservation cancelled.");
                return true;
            }
        }
        System.out.println("Reservation ID not found.");
        return false;
    }

    public void viewBookingDetails(String resId) {
        for (Reservation r : reservations) {
            if (r.getReservationId().equals(resId)) {
                System.out.println("\nReservation Details:");
                System.out.println("ID: " + r.getReservationId());
                System.out.println("Customer: " + r.getCustomerName());
                System.out.println("Room: " + r.getRoomNumber());
                System.out.println("Total: ₹" + r.totalCost);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public void simulatePayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + "... Done!");
    }
}
