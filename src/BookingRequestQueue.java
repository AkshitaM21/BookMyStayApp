import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    Queue<Reservation> queue = new LinkedList<>();

    void addRequest(Reservation r) {
        queue.add(r);
        System.out.println("Booking request added for " + r.guestName);
    }

    void showRequests() {
        System.out.println("\n===== Booking Requests in Queue =====");

        for (Reservation r : queue) {
            System.out.println("Guest: " + r.guestName + " | Room Type: " + r.roomType);
        }
    }

    Reservation getNextRequest() {
        return queue.poll();
    }

    boolean hasRequests() {
        return !queue.isEmpty();
    }
}