import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    public void testParkCar() throws ParkingSpaceNotAvailable, CarAlreadyParkedException {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
    }

    @Test
    public void shouldParkMoreThan1CarWhenCapacityIsAvailable() throws ParkingSpaceNotAvailable, CarAlreadyParkedException {
        Vehicle car = new Car("123");
        Vehicle anotherCar = new Car("456");
        ParkingLot parkingLot = new ParkingLot(2);
        assertTrue(parkingLot.parkVehicle(car));
        assertTrue(parkingLot.parkVehicle(anotherCar));
    }

    @Test
    public void shouldReturnFalseWhenCapacityIsNotAvailable() throws ParkingSpaceNotAvailable, CarAlreadyParkedException {
        Vehicle car = new Car("123");
        Vehicle anotherCar = new Car("456");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
        assertFalse(parkingLot.parkVehicle(anotherCar));
    }

    @Test
    public void shouldReturnTrueWhenUnparking() throws CarNotParkedException, ParkingSpaceNotAvailable, CarAlreadyParkedException {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.parkVehicle(car);
        parkingLot.unparkVehicle(car);
        //doNothing().when(parkingLot.unparkVehicle(car));
    }

    @Test
    public void shouldThrowExceptionIfCarNotParkedWhenUnparking() {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(10);
        assertThrows(CarNotParkedException.class, () -> parkingLot.unparkVehicle(car));

    }

    @Test
    public void testNotifyOwnerWhenParkingLotIsFull() throws ParkingSpaceNotAvailable, CarAlreadyParkedException {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
    }

    @Test
    public void testNotifySecurityWhenParkingLotIsFull () throws CarAlreadyParkedException, ParkingSpaceNotAvailable {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        assertTrue(parkingLot.parkVehicle(car));
    }

    @Test
    public void testNotifyOwnerWhenPakingLotIsAvailable() throws CarAlreadyParkedException, ParkingSpaceNotAvailable, CarNotParkedException {
        Vehicle car = new Car("123");
        ParkingLot parkingLot = new ParkingLot(1);
        Notifier notifier = new Notifier();
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        notifier.addSubscriber(parkingLotOwner);
        notifier.addSubscriber(new ParkingLotSecurity());
        parkingLot.parkVehicle(car);
        parkingLot.unparkVehicle(car);

//        assertTrue(parkingLotOwner.notify());
    }

    @Test
    public void testParkCarInFreeSlot() throws CarAlreadyParkedException, ParkingSpaceNotAvailable {
        Vehicle car = new Car("123");
        Valet valet = new Valet();
        valet.addParkingLot(new ParkingLot(10));
        valet.addParkingLot(new ParkingLot(20));
        assertTrue(valet.park(car));
    }

    @Test
    public void shouldReturnFalseWhenParkingSlotNotAvailable() throws CarAlreadyParkedException, ParkingSpaceNotAvailable {
        Vehicle car = new Car("123");
        Valet valet = new Valet();
        valet.addParkingLot(new ParkingLot(0));
        assertFalse(valet.park(car));
    }
}
