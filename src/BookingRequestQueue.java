import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    Queue<Reservation> queue = new LinkedList<>();

    void addRequest(Reservation r) {
        queue.add(r);
        System.out.println("Request added for " + r.guestName);
    }

    void showRequests() {
        System.out.println("\n===== Booking Request Queue (FIFO) =====");

        for (Reservation r : queue) {
            r.display();
        }
    }
}