import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    public void testParkCar() {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
    }

    @Test
    public void shouldParkMoreThan1CarWhenCapacityIsAvailable() {
        Vehicle car = new Car("123");
        Vehicle anotherCar = new Car("456");
        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot.parkVehicle(car));
        assertTrue(parkingLot.parkVehicle(anotherCar));
    }

    @Test
    public void shouldReturnFalseWhenCapacityIsNotAvailable() {
        Vehicle car = new Car("123");
        Vehicle anotherCar = new Car("456");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
        assertFalse(parkingLot.parkVehicle(anotherCar));
    }

}
