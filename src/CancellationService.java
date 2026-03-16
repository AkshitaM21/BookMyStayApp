import java.util.*;

class CancellationService {

    Stack<String> rollbackStack = new Stack<>();

    void cancelReservation(String guestName, String roomType, String roomId,
                           Map<String, Integer> inventory,
                           List<String> bookingHistory) {

        if (!bookingHistory.contains(guestName)) {
            System.out.println("Cancellation Failed: Reservation not found.");
            return;
        }

        rollbackStack.push(roomId);

        int count = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, count + 1);

        bookingHistory.remove(guestName);

        System.out.println("Reservation cancelled for " + guestName);
        System.out.println("Room released: " + rollbackStack.pop());
        System.out.println("Updated inventory for " + roomType + ": " + inventory.get(roomType));
    }
}