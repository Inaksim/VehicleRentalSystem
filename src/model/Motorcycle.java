package model;

public class Motorcycle extends Vehicle {
    private int driverAge;

    public Motorcycle(String brand, String model, double rentalCostPerDay, int driverAge, double vehicleValue) {
        super(brand, model, rentalCostPerDay, vehicleValue);
        this.driverAge = driverAge;
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        if (rentalDays > 7) {
            return rentalDays * 10.0;
        } else {
            return rentalDays * 15.0;
        }
    }

    @Override
    public double calculateInsuranceCost(int rentalDays) {
        double dailyInsuranceRate = vehicleValue * 0.0002;
        if (driverAge < 25) {
            dailyInsuranceRate *= 1.2; // 20% increase for drivers under 25
        }
        return rentalDays * dailyInsuranceRate;
    }

    @Override
    public String getRentalDetails(String clientName, String startDate, String endDate, String actualReturnDate, int rentalDays, int actualRentalDays) {
        double totalRentalCost = calculateRentalCost(actualRentalDays);
        double totalInsuranceCost = calculateInsuranceCost(actualRentalDays);
        double dailyRentalRate = totalRentalCost / actualRentalDays;
        double dailyInsuranceRate = totalInsuranceCost / actualRentalDays;
        double insuranceSurcharge = dailyInsuranceRate - (vehicleValue * 0.0002);

        return String.format(
                "Motorcycle valued at $%.2f, driver is %d years old:\n" +
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
                        "Initial daily insurance cost: $%.2f\n" +
                        "Insurance surcharge per day: $%.2f\n" +
                        "Daily insurance cost: $%.2f\n" +
                        "Total rental cost: $%.2f\n" +
                        "Total insurance cost: $%.2f\n" +
                        "Total: $%.2f\nXXXXXX",
                vehicleValue, driverAge, actualReturnDate, clientName, brand, model, startDate, endDate, rentalDays, actualReturnDate,
                actualRentalDays, dailyRentalRate, vehicleValue * 0.0002, insuranceSurcharge, dailyInsuranceRate, totalRentalCost, totalInsuranceCost, totalRentalCost + totalInsuranceCost
        );
    }
}
