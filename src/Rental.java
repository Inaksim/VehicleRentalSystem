import model.Vehicle;

public class Rental {

    private Vehicle vehicle;
    private int rentalDays;
    private int actualRentalDays;

    public Rental(Vehicle vehicle, int rentalDays) {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.actualRentalDays = rentalDays;
    }

    public void returnEarly(int actualDays) {
        this.actualRentalDays = actualDays;
    }

    public int getActualRentalDays() {
        return actualRentalDays;
    }
}
