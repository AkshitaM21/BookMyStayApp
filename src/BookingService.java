import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BookingService {

    Set<String> allocatedRooms = new HashSet<>();
    HashMap<String, Set<String>> roomMap = new HashMap<>();

    void processBooking(BookingRequestQueue queue, InventoryService inventory) {

        int id = 1;

        while (queue.hasRequests()) {

            Reservation r = queue.getNextRequest();

            if (inventory.checkAvailability(r.roomType)) {

                String roomId = r.roomType.replace(" ", "") + id++;

                allocatedRooms.add(roomId);

                roomMap.putIfAbsent(r.roomType, new HashSet<>());
                roomMap.get(r.roomType).add(roomId);

                inventory.reduceRoom(r.roomType);

                System.out.println("Reservation Confirmed for "
                        + r.guestName + " | Room ID: " + roomId);
            } else {

                System.out.println("No rooms available for " + r.roomType);
            }
        }
    }
}