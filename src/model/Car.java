package model;

public class Car extends Vehicle{
    private int safetyRating;

    public Car(String brand, String model, double rentalCostPerDay, int safetyRating, double vehicleValue) {
        super(brand, model, rentalCostPerDay, vehicleValue);
        this.safetyRating = safetyRating;
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        if(rentalDays > 7) {
            return rentalDays * 15.0;
        } else {
            return rentalDays * 20.0;
        }
    }

    @Override
    public double calculateInsuranceCost(int rentalDays) {
        double dailyInsuranceRate = vehicleValue * 0.0001;
        if (safetyRating >= 4) {
            dailyInsuranceRate *= 0.9;
        }
        return rentalDays * dailyInsuranceRate;
    }

    @Override
    public String getRentalDetails(String clientName, String startDate, String endDate, String actualReturnDate, int rentalDays, int actualRentalDays) {
        double totalRentalCost = calculateRentalCost(actualRentalDays);
        double totalInsuranceCost = calculateInsuranceCost(actualRentalDays);
        double dailyRentalRate = totalRentalCost / actualRentalDays;
        double dailyInsuranceRate = totalInsuranceCost / actualRentalDays;

        return String.format(
                "Car valued at $%.2f with a safety rating of %d:\n" +
                        "XXXXXX\n" +
                        "Date: %s\n" +
                        "Client name: %s\n" +
                        "Rented vehicle: %s %s\n" +
                        "Rental start date: %s\n" +
                        "Rental end date: %s\n" +
                        "Reserved rental days: %d days\n" +
                        "Actual return date: %s\n" +
                        "Actual rental days: %d days.\n" +
                        "Daily rental cost: $%.2f\n" +
                        "Daily insurance cost: $%.2f\n" +
                        "Total rental cost: $%.2f\n" +
                        "Total insurance cost: $%.2f\n" +
                        "Total: $%.2f\nXXXXXX",
                vehicleValue, safetyRating, actualReturnDate, clientName, brand, model, startDate, endDate, rentalDays, actualReturnDate,
                actualRentalDays, dailyRentalRate, dailyInsuranceRate, totalRentalCost, totalInsuranceCost, totalRentalCost + totalInsuranceCost
        );
    }
}
