import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Vehicle> parkedCars = new ArrayList<>();
//    private Map<String, Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean isParked(Vehicle vehicle) {
        if(parkedCars.size() < capacity) {
            parkedCars.add(vehicle);
            vehicle.park();
            return true;
        }

        return false;
    }
}
