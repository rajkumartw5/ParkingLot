import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ParkingLot {
    private final int capacity;
    private List<Vehicle> parkedCars = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (isAvailableToPark()) {
            parkedCars.add(vehicle);
            return true;
        }
        System.out.println("Parking space is not available");
        return false;
    }

    public boolean isAvailableToPark() {
        return parkedCars.size() < capacity;
    }
}
