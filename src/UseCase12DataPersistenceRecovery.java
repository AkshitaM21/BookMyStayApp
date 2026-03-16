import java.io.*;
import java.util.*;

class Booking implements Serializable {
    int roomNumber;
    String guestName;

    Booking(int roomNumber, String guestName) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
    }

    public String toString() {
        return "Room " + roomNumber + " booked by " + guestName;
    }
}

class HotelSystem implements Serializable {

    Map<Integer, Booking> bookings = new HashMap<>();
    int totalRooms = 5;

    void bookRoom(int room, String name) {
        if (room < 1 || room > totalRooms) {
            System.out.println("Invalid room number");
            return;
        }

        if (bookings.containsKey(room)) {
            System.out.println("Room already booked!");
        } else {
            bookings.put(room, new Booking(room, name));
            System.out.println("Booking successful");
        }
    }

    void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found");
        } else {
            for (Booking b : bookings.values()) {
                System.out.println(b);
            }
        }
    }
}

class PersistenceService {

    static void saveState(HotelSystem system) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("hotel_state.dat"));
            out.writeObject(system);
            out.close();
            System.out.println("System state saved.");
        } catch (Exception e) {
            System.out.println("Error saving state.");
        }
    }

    static HotelSystem loadState() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("hotel_state.dat"));
            HotelSystem system = (HotelSystem) in.readObject();
            in.close();
            System.out.println("System state restored.");
            return system;
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return new HotelSystem();
        }
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        HotelSystem system = PersistenceService.loadState();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Book Room");
            System.out.println("2.View Bookings");
            System.out.println("3.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter room number: ");
                    int room = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();

                    system.bookRoom(room, name);
                    break;

                case 2:
                    system.showBookings();
                    break;

                case 3:
                    PersistenceService.saveState(system);
                    System.out.println("System shutting down...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}