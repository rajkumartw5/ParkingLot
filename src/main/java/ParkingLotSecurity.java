public class ParkingLotSecurity implements User{
    @Override
    public void notify(boolean isParkingAvailable) {
        if (!isParkingAvailable) {
            System.out.println("Incoming cars redirected");
        }
        else {
            System.out.println("Stop redirecting the cars");
        }
    }

}
