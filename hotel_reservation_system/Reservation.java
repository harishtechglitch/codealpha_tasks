import java.io.Serializable;
import java.util.UUID;

public class Reservation implements Serializable {
    private String reservationId;
    private String customerName;
    private int roomNumber;
    private String checkInDate;
    private String checkOutDate;
    private double totalCost;

    public Reservation(String customerName, int roomNumber, String checkIn, String checkOut, double totalCost) {
        this.reservationId = UUID.randomUUID().toString().substring(0, 8);
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.totalCost = totalCost;
    }

    public String getReservationId() { return reservationId; }
    public String getCustomerName() { return customerName; }
    public int getRoomNumber() { return roomNumber; }

    @Override
    public String toString() {
        return reservationId + "," + customerName + "," + roomNumber + "," + checkInDate + "," + checkOutDate + "," + totalCost;
    }

    public static Reservation fromString(String data) {
        String[] parts = data.split(",");
        Reservation r = new Reservation(parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], Double.parseDouble(parts[5]));
        r.reservationId = parts[0];
        return r;
    }
}
