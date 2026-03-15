class Room {

    String type;
    int price;
    String amenities;

    Room(String type, int price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: " + price);
        System.out.println("Amenities: " + amenities);
    }
}

class SearchService {

    void searchRooms(RoomInventory inventory, Room[] rooms) {

        System.out.println("===== Available Rooms =====");

        for (int i = 0; i < rooms.length; i++) {

            int available = inventory.getAvailability(rooms[i].type);

            if (available > 0) {
                rooms[i].displayDetails();
                System.out.println("Available Count: " + available);
                System.out.println("-------------------------");
            }
        }
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room[] rooms = new Room[3];

        rooms[0] = new Room("Single Room", 2000, "WiFi, TV");
        rooms[1] = new Room("Double Room", 3500, "WiFi, AC, TV");
        rooms[2] = new Room("Suite Room", 6000, "WiFi, AC, TV, Mini Bar");

        SearchService search = new SearchService();

        search.searchRooms(inventory, rooms);
    }
}