import java.util.Arrays;
import java.util.List;

class InvalidBookingValidator {

    List<String> validRooms = Arrays.asList(
            "Single Room",
            "Double Room",
            "Suite Room"
    );

    void validate(String guestName, String roomType) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!validRooms.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }
    }
}