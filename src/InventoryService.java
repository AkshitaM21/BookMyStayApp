import java.util.HashMap;

class InventoryService {

    HashMap<String, Integer> inventory = new HashMap<>();

    InventoryService() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    boolean checkAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    void reduceRoom(String roomType) {
        int count = inventory.get(roomType);
        inventory.put(roomType, count - 1);
    }
}