public class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber);
    }

    @Override
    public void park() {
        System.out.println("Car is parked");
    }
}
