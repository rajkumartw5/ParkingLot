import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
    @Test
    public void testParkCar() {
        Car car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        assertTrue(parkingLot.isParked(car));
    }
}
