import java.util.*;

public class UseCase11ConcurrentBookingSimulation {

    // Shared booking queue
    static class BookingQueue {
        Queue<String> queue = new LinkedList<>();

        public synchronized void addRequest(String guest) {
            queue.add(guest);
            System.out.println("Request added: " + guest);
        }

        public synchronized String getRequest() {
            return queue.poll();
        }
    }

    // Shared inventory
    static class Inventory {

        Map<String, Integer> rooms = new HashMap<>();

        Inventory() {
            rooms.put("Single Room", 2);
        }

        public synchronized void allocateRoom(String guest) {

            int count = rooms.get("Single Room");

            if (count > 0) {
                rooms.put("Single Room", count - 1);
                System.out.println(guest + " booked Single Room | Remaining: " + rooms.get("Single Room"));
            } else {
                System.out.println("No rooms available for " + guest);
            }
        }
    }

    // Thread processor
    static class BookingProcessor extends Thread {

        BookingQueue queue;
        Inventory inventory;

        BookingProcessor(BookingQueue q, Inventory i) {
            queue = q;
            inventory = i;
        }

        public void run() {

            String guest = queue.getRequest();

            if (guest != null) {
                inventory.allocateRoom(guest);
            }
        }
    }

    // Main logic
    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        Inventory inventory = new Inventory();

        queue.addRequest("Akshita");
        queue.addRequest("Rahul");
        queue.addRequest("Priya");

        BookingProcessor t1 = new BookingProcessor(queue, inventory);
        BookingProcessor t2 = new BookingProcessor(queue, inventory);
        BookingProcessor t3 = new BookingProcessor(queue, inventory);

        t1.start();
        t2.start();
        t3.start();
    }
}