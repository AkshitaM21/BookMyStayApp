public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Akshita", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));

        InventoryService inventory = new InventoryService();

        BookingService service = new BookingService();

        service.processBooking(queue, inventory);
    }
}