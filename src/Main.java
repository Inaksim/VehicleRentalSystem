import model.Car;
import model.Motorcycle;
import model.Van;
import model.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Rental System");
        System.out.print("Enter your name: ");
        String clientName = scanner.nextLine();

        System.out.println("Choose vehicle type (1. Car, 2. Motorcycle, 3. Van): ");
        int vehicleType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter rental cost per day: ");
        double rentalCostPerDay = scanner.nextDouble();
        System.out.print("Enter vehicle value: ");
        double vehicleValue = scanner.nextDouble();

        Vehicle vehicle = null;

        switch (vehicleType) {
            case 1:
                System.out.print("Enter safety rating (1-5): ");
                int safetyRating = scanner.nextInt();
                vehicle = new Car(brand, model, rentalCostPerDay, safetyRating, vehicleValue);
                break;
            case 2:
                System.out.print("Enter driver's age: ");
                int driverAge = scanner.nextInt();
                vehicle = new Motorcycle(brand, model, rentalCostPerDay, driverAge, vehicleValue);
                break;
            case 3:
                System.out.print("Enter driver's experience in years: ");
                int driverExperience = scanner.nextInt();
                vehicle = new Van(brand, model, rentalCostPerDay, driverExperience, vehicleValue);
                break;
            default:
                System.out.println("Invalid vehicle type selected.");
                System.exit(0);
        }

        System.out.print("Enter rental duration in days: ");
        int rentalDays = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy г.");
        String currentDateStr = currentDate.format(formatter);

        System.out.print("Enter rental start date (dd/MM/yyyy): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDate = startDate.plusDays(rentalDays - 1);
        String endDateStr = endDate.format(formatter);

        Rental rental = new Rental(vehicle, rentalDays);
        System.out.println("Do you want to return the vehicle early? (yes/no): ");
        String earlyReturn = scanner.nextLine();

        if (earlyReturn.equalsIgnoreCase("yes")) {
            System.out.print("Enter actual rental days: ");
            int actualDays = scanner.nextInt();
            rental.returnEarly(actualDays);
        }

        String rentalDetails = vehicle.getRentalDetails(clientName, startDateStr, endDateStr, currentDateStr, rentalDays, rental.getActualRentalDays());
        System.out.println(rentalDetails);
    }


}