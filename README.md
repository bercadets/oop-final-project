<h1 align = "center">   VEHICLE RENTAL MANAGEMENT SYSTEM </h1>


<h1 align="center">
\____________________/<br>
__/__|__________|__\__<br>
/⭕⭕_______⭕⭕\<br>
|__/_____GIAN______\__| <br>
\©©__|_|_|_|_|__©©/<br>
 
</h1>

## 🔎 Overview

 A `console-based Vehicle Rental System` implemented in Java that allows users to manage a fleet of rentable vehicles. The system supports different types of vehicles (cars and bicycles) with functionality for renting, returning, adding, removing, and updating vehicle information through an interactive menu-driven interface.


## 📦 Features

## Features

- Rent a vehicle  
- Return a rented vehicle  
- Add a new vehicle (Car or Bicycle)  
- Remove an existing vehicle  
- Update the hourly rental price of a vehicle  
- View all vehicles in the inventory  
- Identify which vehicles are rented or available  
- Supports multiple vehicle types through OOP  


## 📈 Project Structure
```
📂 VehicleRentalSystem/
    ├── 📄 CarRental.java       
    ├── 📄 RentalSystem.java     
    ├── 📄 Vehicle.java         
    ├── 📄 Car.java          
    └── 📄 Bicycle.java     
```
- `CarRental.java` - Main class with entry point
- `RentalSystem.java` - Core system logic and menu handling
- `Vehicle.java` -  Abstract base class for all vehicles
- `Car.java` - Concrete class for car vehicles
- `Bicycle.java` - Concrete class for bicycle vehicles

### How to Run the Program
Open terminal in the src/ folder and run:
```
javac VehicleRentalSystem/*.java
```
Run the program using:
```
java VehicleRentalSystem.Main
```

## 👨‍💻 Object-Oriented Principles

### 💊 Encapsulation
Encapsulation is implemented by making all fields in the Vehicle class private and providing public getter and setter methods to control access to the vehicle's name, hourly rate, and rental status.

### 🧱 Abstraction
Abstraction is implemented by declaring the Vehicle class as abstract with an abstract `getType()` method, which forces all subclasses to define their specific vehicle type while hiding the internal implementation details from the user.


### 🧬 Inheritance
Inheritance is demonstrated through the Car and Bicycle classes extending the Vehicle base class, where they inherit common properties like name, hourly rate, and rental status while using the `super()` constructor to set their specific values.

### 👥 Polymorphism
Polymorphism is achieved through method overriding(`@Override`), where both Car and Bicycle classes provide their own specific implementation of the `getType()` method that was defined in the parent Vehicle class.

## Example Output


## 🌸 Acknowledgement

We would like to extend our sincere gratitude to everyone who supported us in the completion of this project.

Our deepest thanks go to our instructor, Mr. Emmanuel Charlie Enriquez, for his invaluable guidance, expert insights, and unwavering patience throughout this process. Your mentorship has been instrumental in shaping our work and deepening our understanding.

— *The Team* ✨


## 👥 Authors  
### **Team 1** - *The Missionaries*

| Members                         | Github Profile                                             |
| ------------------------------- | ---------------------------------------------------------- |
| **Baes, Gian Louie D.**         | [@HaiseSasaki23](https://github.com/HaiseSasaki23)         |
| **Davalos, Nicko Bryan J.**     | [@bercadets](https://github.com/bercadets)                 |
| **Mayuga, Nash D.**             | [@shany20](https://github.com/shany20)                     |
