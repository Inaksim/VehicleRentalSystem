package model;

public class Van extends Vehicle {
    private int driverExperience;

    public Van(String brand, String model, double rentalCostPerDay, int driverExperience, double vehicleValue) {
        super(brand, model, rentalCostPerDay, vehicleValue);
        this.driverExperience = driverExperience;
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        if (rentalDays > 7) {
            return rentalDays * 40.0;
        } else {
            return rentalDays * 50.0;
        }
    }

    @Override
    public double calculateInsuranceCost(int rentalDays) {
        double dailyInsuranceRate = vehicleValue * 0.0003;
        if (driverExperience > 5) {
            dailyInsuranceRate *= 0.85; // 15% discount for experienced drivers
        }
        return rentalDays * dailyInsuranceRate;
    }

    @Override
    public String getRentalDetails(String clientName, String startDate, String endDate, String actualReturnDate, int rentalDays, int actualRentalDays) {
        double totalRentalCost = calculateRentalCost(actualRentalDays);
        double totalInsuranceCost = calculateInsuranceCost(actualRentalDays);
        double dailyRentalRate = totalRentalCost / actualRentalDays;
        double dailyInsuranceRate = totalInsuranceCost / actualRentalDays;
        double insuranceDiscount = (vehicleValue * 0.0003) - dailyInsuranceRate;
        double earlyReturnRentalDiscount = ((rentalDays - actualRentalDays) * dailyRentalRate) / 2;
        double earlyReturnInsuranceDiscount = calculateInsuranceCost(rentalDays - actualRentalDays);

        return String.format(
                "Van valued at $%.2f, driver has %d years of experience:\n" +
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
                        "Insurance discount per day: $%.2f\n" +
                        "Daily insurance cost: $%.2f\n" +
                        "Early return rental discount: $%.2f\n" +
                        "Early return insurance discount: $%.2f\n" +
                        "Total rental cost: $%.2f\n" +
                        "Total insurance cost: $%.2f\n" +
                        "Total: $%.2f\nXXXXXX",
                vehicleValue, driverExperience, actualReturnDate, clientName, brand, model, startDate, endDate, rentalDays, actualReturnDate,
                actualRentalDays, dailyRentalRate, vehicleValue * 0.0003, insuranceDiscount, dailyInsuranceRate, earlyReturnRentalDiscount, earlyReturnInsuranceDiscount,
                totalRentalCost, totalInsuranceCost, totalRentalCost + totalInsuranceCost - earlyReturnRentalDiscount - earlyReturnInsuranceDiscount
        );
    }

}
