# DriveAndDeliver

**DriveAndDeliver** is a Spring Boot application designed to facilitate various delivery methods for a retail system. The application allows customers to choose between different delivery options such as DRIVE, DELIVERY, DELIVERY_TODAY, and DELIVERY_ASAP, each tailored to different needs and urgencies.

## Features

- **Choose Delivery Method**: Customers can select their preferred delivery method.
- **Schedule Delivery**: Customers can choose specific days and time slots for their delivery, based on the selected delivery method.

## Prerequisites

Before you begin, ensure you have met the following requirements:
- **Java 21**: Ensure Java JDK 21 is installed on your machine. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).
- **Maven**: The project uses Maven for dependency management and build. Install it from [Maven's official site](https://maven.apache.org/download.cgi).

## Getting Started

These instructions will get your copy of the project up and running on your local machine for development and testing purposes.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/charafmail/DriveAndDeliver.git
   cd DriveAndDeliver
   
Build the project:
   ```bash
mvn clean install
   ```
Run the application:
  ```bash
mvn spring-boot:run
 ```
## Using the Application
Once the application is running, you can access the following endpoints via a tool like Postman or through your browser (if applicable):
 
```bash
GET /api/v1/delivery-methods - Retrieve a list of available delivery methods.
POST /api//v1/select-delivery-method - Select a delivery method for an order.
GET /api//v1/time-slots/{deliveryMethod} - Retrieve available time slots for a given delivery method.
POST /api//v1/book-time-slot - Book a specific time slot for delivery.
 ```
## Configuration
The application can be configured via the application.properties file located in src/main/resources. Adjust database settings and other configurations as needed.

## Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

## Fork the Project
Create your Feature Branch (git checkout -b feature/NewFeature)
Commit your Changes (git commit -m 'Add some NewFeature')
Push to the Branch (git push origin feature/NewFeature)

## Contact
charafeddine.mail@mail.com

## Project Link:
https://github.com/charafmail/DriveAndDeliver

