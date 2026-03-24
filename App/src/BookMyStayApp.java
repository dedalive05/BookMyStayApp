import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {

    abstract static class Room {
        protected int numberOfBeds;
        protected int squareFeet;
        protected double pricePerNight;

        public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
            this.numberOfBeds = numberOfBeds;
            this.squareFeet = squareFeet;
            this.pricePerNight = pricePerNight;
        }

        public void displayRoomDetails() {
            System.out.println("Beds: " + numberOfBeds);
            System.out.println("Size: " + squareFeet + " sqft");
            System.out.println("Price per night: " + pricePerNight);
        }
    }

    static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 250, 1500.0);
        }
    }

    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 488, 2500.0);
        }
    }

    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 750, 5000.0);
        }
    }

    static class RoomInventory {
        private Map<String, Integer> roomsAvailability = new HashMap<>();

        public RoomInventory() {
            initializeInventory();
        }

        private void initializeInventory() {
            roomsAvailability.put("Single Room", 5);
            roomsAvailability.put("Double Room", 3);
            roomsAvailability.put("Suite Room", 2);
        }

        public Map<String, Integer> getRoomAvailability() {
            return roomsAvailability;
        }

        public void setRoomAvailability(String roomType, int count) {
            roomsAvailability.put(roomType, count);
        }
    }

    public static class UseCase3InventorySetup {

        public static void main(String[] args) {
            RoomInventory inventory = new RoomInventory();

            SingleRoom single = new SingleRoom();
            DoubleRoom dbl = new DoubleRoom();
            SuiteRoom suite = new SuiteRoom();

            System.out.println("Hotel Room Inventory Status\n");

            System.out.println("Single Room:");
            single.displayRoomDetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single Room") + "\n");

            System.out.println("Double Room:");
            dbl.displayRoomDetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double Room") + "\n");

            System.out.println("Suite Room:");
            suite.displayRoomDetails();
            System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite Room"));
        }
    }
}