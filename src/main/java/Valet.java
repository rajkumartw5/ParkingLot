import java.util.ArrayList;
import java.util.List;

public class Valet {
    List<ParkingLot> parkingLots;

    public Valet() {
        this.parkingLots = new ArrayList<>();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public boolean park(Vehicle car) throws CarAlreadyParkedException, ParkingSpaceNotAvailable {
        for (ParkingLot parkingLot: parkingLots) {
            if (parkingLot.isAvailableToPark()){
                parkingLot.parkVehicle(car);
                return true;
            }
        }
        return false;
    }
}
