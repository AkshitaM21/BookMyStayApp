import java.util.List;

class BookingReportService {

    void generateReport(BookingHistory history) {

        List<Reservation> bookings = history.getAllReservations();

        System.out.println("\n===== Booking History Report =====");

        for (Reservation r : bookings) {
            System.out.println("Guest: " + r.guestName +
                    " | Room Type: " + r.roomType);
        }

        System.out.println("\nTotal Bookings: " + bookings.size());
    }
}