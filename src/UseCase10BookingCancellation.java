import java.util.*;

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        List<String> bookingHistory = new ArrayList<>();

        bookingHistory.add("Akshita");
        bookingHistory.add("Rahul");

        CancellationService cancelService = new CancellationService();

        cancelService.cancelReservation(
                "Akshita",
                "Single Room",
                "S101",
                inventory,
                bookingHistory
        );

        cancelService.cancelReservation(
                "Priya",
                "Suite Room",
                "SU201",
                inventory,
                bookingHistory
        );
    }
}