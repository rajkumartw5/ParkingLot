public class ParkingLotOwner implements User {
    @Override
    public void notify(boolean isParkingAvailable) {
        if (!isParkingAvailable)
            System.out.println("Put up the board - Parking Lot is full");

        else
            System.out.println("Put down the board");

    }
}
