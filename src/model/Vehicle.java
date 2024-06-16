package model;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected double vehicleValue;
    protected double rentalCostPerDay;

    public Vehicle(String brand, String model, double rentalCostPerDay, double vehicleValue) {
        this.brand = brand;
        this.model = model;
        this.rentalCostPerDay = rentalCostPerDay;
        this.vehicleValue = vehicleValue;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public double getVehicleValue() {
        return vehicleValue;
    }

    public abstract double calculateRentalCost(int rentalDay);

    public abstract double calculateInsuranceCost(int rentalDay);

    public abstract String getRentalDetails(String clientName,
                                            String startDate,
                                            String endDate,
                                            String actualReturnDate,
                                            int rentalDays,
                                            int actualRentalDays);


}
