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
            super(2, 468, 2500.0);
        }
    }

    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 758, 5000.0);
        }
    }

    static class RoomInventory {
        private Map<String, Integer> roomsAvailability = new HashMap<>();

        public RoomInventory() {
            initializeInventory();
        }

        private void initializeInventory() {
            roomsAvailability.put("Single", 5);
            roomsAvailability.put("Double", 3);
            roomsAvailability.put("Suite", 2);
        }

        public Map<String, Integer> getRoomAvailability() {
            return roomsAvailability;
        }
    }

    static class RoomSearchService {

        public void searchAvailableRooms(RoomInventory inventory,
                                         Room singleRoom,
                                         Room doubleRoom,
                                         Room suiteRoom) {
            Map<String, Integer> availability = inventory.getRoomAvailability();

            System.out.println("Room Search\n");

            if (availability.get("Single") > 0) {
                System.out.println("Single Room:");
                singleRoom.displayRoomDetails();
                System.out.println("Available: " + availability.get("Single") + "\n");
            }

            if (availability.get("Double") > 0) {
                System.out.println("Double Room:");
                doubleRoom.displayRoomDetails();
                System.out.println("Available: " + availability.get("Double") + "\n");
            }

            if (availability.get("Suite") > 0) {
                System.out.println("Suite Room:");
                suiteRoom.displayRoomDetails();
                System.out.println("Available: " + availability.get("Suite") + "\n");
            }
        }
    }

    public static class UseCase4RoomSearch {

        public static void main(String[] args) {
            RoomInventory inventory = new RoomInventory();
            SingleRoom single = new SingleRoom();
            DoubleRoom dbl = new DoubleRoom();
            SuiteRoom suite = new SuiteRoom();

            RoomSearchService searchService = new RoomSearchService();
            searchService.searchAvailableRooms(inventory, single, dbl, suite);
        }
    }
}