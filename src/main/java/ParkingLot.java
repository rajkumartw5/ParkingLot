import java.util.*;

public class ParkingLot {
    private final int capacity;
    private Set<Vehicle> parkedCars = new HashSet<>();
    List<User> subscribers;
    private boolean isAvailable;

    private Notifier notifier;
//    private ParkingLotOwner owner;
//    private ParkingLotSecurity parkingLotSecurity;



    private boolean isNotifiedForLotIsFull = false;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.subscribers = new ArrayList<>();
        this.isAvailable = true;
        notifier = new Notifier();
    }

    public boolean parkVehicle(Vehicle vehicle) throws ParkingSpaceNotAvailable, CarAlreadyParkedException {
        if (parkedCars.contains(vehicle)) {
            throw new CarAlreadyParkedException();
        }
        if (!isAvailableToPark()) {
            System.out.println("Parking space is not available");
            throw new ParkingSpaceNotAvailable();
        }
        parkedCars.add(vehicle);
        if (parkedCars.size() == capacity) {
            isNotifiedForLotIsFull = true;
//            isAvailable = false;
            notifyObservers(true);
        }
        return isNotifiedForLotIsFull;
    }

    public boolean isAvailableToPark() {
        return parkedCars.size() < capacity;
    }

    public void unparkVehicle(Vehicle car) throws CarNotParkedException {
        if (!parkedCars.contains(car)){
            throw new CarNotParkedException();
        }

        if (parkedCars.size() == capacity) {
            parkedCars.remove(car);
            notifyObservers(false);
        }

//        parkedCars.remove(car);
//        if (!isAvailable){
//            isAvailable = true;
//            notifyObservers(isAvailable);
//        }
        System.out.println("Vehicle is now unparked");
    }

    public void notifyObservers(boolean value) {
        notifier.notifyObservers(value);
    }

//    public void notifyActor() {
//        Notification notification = new Notification();
//        notification.notify("Parking Lot is full");
//    }


//    @Override
//    public void addSubscriber(User user) {
//        this.subscribers.add(user);
//    }


}
