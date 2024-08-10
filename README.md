
# Hotel Management System

This Java-based Hotel Management System is a mini-project designed to simulate the essential operations of a hotel. It allows users to manage room bookings, handle customer details, order items, and generate bills. The project is structured into three main files, each contributing different functionalities to the system.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Components](#components)
- [Usage](#usage)
- [License](#license)

## Project Overview

This Hotel Management System is implemented in Java and leverages object-oriented principles to manage hotel operations. It includes classes for different room types, services like food and toiletries, and handles booking, billing, and room availability.

## Features

- **Room Management**: Book, check availability, and manage different room types.
- **Customer Management**: Capture and store customer details.
- **Order Management**: Allow customers to order food and toiletries.
- **Billing System**: Generate bills based on room type, services used, and duration of stay.
- **Exception Handling**: Manage exceptions like room availability.

## Components

The project consists of three main files:

### 1. `Rooms.java`
This file contains the following classes:
- **Food & Toiletries**: Hold item number, price, and quantity.
- **Regular_Room & Double_Room**: Define features for different room types, including customer name, contact, and purchased items.
- **NotAvailable**: Extends the `Exception` class to handle room availability.
- **Holder**: Manages arrays of `Regular_Room` and `Double_Room` to hold different room types available in the hotel.

### 2. `Hotel_Class.java`
Contains the `Hotel` class with methods to manage the hotel operations:
- `CustDetails`: Collects and stores customer details.
- `bookRoom`: Books a room based on availability.
- `availability`: Checks and displays room availability.
- `bill`: Calculates the total bill for a room.
- `checkOut`: Handles the checkout process and calculates the final bill.
- `order`: Adds items to a room’s order list.
- `buy`: Adds items to a room’s toiletries list.

### 3. `Hotel_Main.java`
This file contains the main method and serves as the entry point for the system. It utilizes classes from `Rooms.java` and `Hotel_Class.java` and provides a command-line interface using a switch-case nested in a while loop.

## Usage

The program provides a command-line interface where you can:
- **Book a room**: Select a room type and book it based on availability.
- **Order items**: Add food or toiletries to your room’s order.
- **Check availability**: View available rooms.
- **Generate bill**: Calculate the bill based on room type, items ordered, and duration.
- **Checkout**: Checkout a room and finalize the billing.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

