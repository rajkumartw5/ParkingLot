public class Vehicle {
    private final String licenseNumber;
    public Vehicle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void park() {
        System.out.println("Vehicle is parked");
    }
}
