import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String category;
    private boolean isAvailable;
    private double pricePerNight;

    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public double getPricePerNight() { return pricePerNight; }

    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return roomNumber + "," + category + "," + isAvailable + "," + pricePerNight;
    }

    public static Room fromString(String data) {
        String[] parts = data.split(",");
        return new Room(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[3]));
    }
}
