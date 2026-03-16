public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        InvalidBookingValidator validator = new InvalidBookingValidator();

        try {

            String guestName = "Akshita";
            String roomType = "Single Room";

            validator.validate(guestName, roomType);

            System.out.println("Booking input validated successfully.");

        } catch (InvalidBookingException e) {

            System.out.println("Booking Failed: " + e.getMessage());
        }

        try {

            String guestName = "";
            String roomType = "Luxury Room";

            validator.validate(guestName, roomType);

        } catch (InvalidBookingException e) {

            System.out.println("Booking Failed: " + e.getMessage());
        }
    }
}