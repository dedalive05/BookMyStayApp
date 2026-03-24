import java.util.*;

public class BookMyStayApp {

    public static class Reservation {
        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    public static class RoomInventory {
        private Map<String, Integer> roomsAvailability = new HashMap<>();

        public RoomInventory() {
            initializeInventory();
        }

        private void initializeInventory() {
            roomsAvailability.put("Single", 5);
            roomsAvailability.put("Double", 3);
            roomsAvailability.put("Suite", 2);
        }

        public int getAvailableCount(String roomType) {
            return roomsAvailability.getOrDefault(roomType, 0);
        }

        public void reduceAvailability(String roomType) {
            if (roomsAvailability.containsKey(roomType) && roomsAvailability.get(roomType) > 0) {
                roomsAvailability.put(roomType, roomsAvailability.get(roomType) - 1);
            }
        }
    }

    public static class RoomAllocationService {
        private Set<String> allocatedRoomIds = new HashSet<>();
        private Map<String, Set<String>> assignedRoomsByType = new HashMap<>();

        public RoomAllocationService() {
            assignedRoomsByType.put("Single", new HashSet<>());
            assignedRoomsByType.put("Double", new HashSet<>());
            assignedRoomsByType.put("Suite", new HashSet<>());
        }

        public void allocateRoom(Reservation reservation, RoomInventory inventory) {
            String roomType = reservation.getRoomType();
            if (inventory.getAvailableCount(roomType) <= 0) {
                System.out.println("No rooms available for type: " + roomType);
                return;
            }

            String roomId = generateRoomId(roomType);
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.get(roomType).add(roomId);
            inventory.reduceAvailability(roomType);

            System.out.println("Booking confirmed for Guest: " 
                               + reservation.getGuestName() 
                               + ", Room ID: " + roomId);
        }

        private String generateRoomId(String roomType) {
            int count = assignedRoomsByType.get(roomType).size() + 1;
            return roomType + "-" + count;
        }
    }

    public static class UseCase6RoomAllocation {

        public static void main(String[] args) {
            System.out.println("Room Allocation Processing\n");

            RoomInventory inventory = new RoomInventory();
            RoomAllocationService allocationService = new RoomAllocationService();

            Reservation r1 = new Reservation("Abhi", "Single");
            Reservation r2 = new Reservation("Subha", "Single");
            Reservation r3 = new Reservation("Vansathi", "Suite");

            List<Reservation> requests = Arrays.asList(r1, r2, r3);

            for (Reservation res : requests) {
                allocationService.allocateRoom(res, inventory);
            }
        }
    }
}