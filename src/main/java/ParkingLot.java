import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private List<Car> parkedCars = new ArrayList<>();
//    private Map<String, Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean isParked(Car car) {
        if(parkedCars.size() < capacity) {
            parkedCars.add(car);
            return true;
        }

        return false;
    }
}
