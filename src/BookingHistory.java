import java.util.ArrayList;
import java.util.List;

class BookingHistory {

    List<Reservation> history = new ArrayList<>();

    void addReservation(Reservation r) {
        history.add(r);
        System.out.println("Reservation stored for " + r.guestName);
    }

    List<Reservation> getAllReservations() {
        return history;
    }
}