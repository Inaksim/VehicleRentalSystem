

# Vehicle Rental System

## Overview

This Java application is a console-based vehicle rental system. It allows users to rent different types of vehicles (cars, motorcycles, and vans) and calculates the rental costs based on the vehicle type, rental duration, and other relevant parameters.

## Approach to the Solution

The approach taken for this solution involves creating a hierarchy of vehicle classes and a rental system that handles the user input and calculates the rental cost dynamically. Key components include:

- **Vehicle Class Hierarchy**: An abstract base class `Vehicle` and derived classes `Car`, `Motorcycle`, and `Van`.
- **Rental Calculation Logic**: Implemented in the `VehicleRentalSystem` class, which handles user input, validates it, and calculates rental and insurance costs based on predefined business rules.
- **User Interaction**: A console-based interface that guides the user through the process of entering rental details and displays the calculated results.

## Features

- Support for renting cars, motorcycles, and vans.
- Dynamic calculation of rental costs, including daily rental cost, insurance, and discounts.
- User input validation to prevent invalid entries.
- Detailed rental summary for each rental transaction.

