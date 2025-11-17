import java.util.ArrayList;
import java.util.Scanner;

// ABSTRACT CLASS
abstract class Vehicle {
    private String name;
    private double hourlyRate;
    private boolean rented;

    public Vehicle(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.rented = false;
    }

    public abstract String getType();  // POLYMORPHISM

    // ENCAPSULATION
    public String getName() { return name; }
    public double getHourlyRate() { return hourlyRate; }
    public boolean isRented() { return rented; }

    public void setHourlyRate(double rate) { this.hourlyRate = rate; }
    public void setRented(boolean rented) { this.rented = rented; }

    public void printInfo() {
        System.out.println(getType() + " - " + name +
                " | ₱" + hourlyRate +
                " | " + (rented ? "Rented" : "Available"));
    }
}

// INHERITANCE
class Bicycle extends Vehicle {
    public Bicycle(double rate) {
        super("Bicycle", rate);
    }
    @Override
    public String getType() { return "Bicycle"; }
}

class Tricycle extends Vehicle {
    public Tricycle(double rate) {
        super("Tricycle", rate);
    }
    @Override
    public String getType() { return "Tricycle"; }
}

class Car extends Vehicle {
    public Car(double rate) {
        super("Car", rate);
    }
    @Override
    public String getType() { return "Car"; }
}

class RentalSystem {
    private ArrayList<Vehicle> inventory = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public RentalSystem() {
        inventory.add(new Bicycle(20));
        inventory.add(new Tricycle(100));
        inventory.add(new Car(500));
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.println("\nInventory:");
        int i = 1;
        for (Vehicle v : inventory) {
            System.out.print(i++ + ". ");
            v.printInfo();
        }
    }

    public void addVehicle() {
        System.out.println("\nChoose type:");
        System.out.println("[1] Bicycle");
        System.out.println("[2] Tricycle");
        System.out.println("[3] Car");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter hourly rate: ");
        double rate = sc.nextDouble();

        switch (choice) {
            case 1 -> inventory.add(new Bicycle(rate));
            case 2 -> inventory.add(new Tricycle(rate));
            case 3 -> inventory.add(new Car(rate));
            default -> System.out.println("Invalid choice.");
        }

        System.out.println("Vehicle added!");
    }

    public void removeVehicle() {
        showInventory();
        System.out.print("Select index to remove: ");
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= inventory.size()) {
            System.out.println("Invalid index.");
            return;
        }

        if (inventory.get(idx).isRented()) {
            System.out.println("Cannot remove a rented vehicle!");
            return;
        }

        inventory.remove(idx);
        System.out.println("Vehicle removed.");
    }

    public void updatePrice() {
        showInventory();
        System.out.print("Choose vehicle index: ");
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= inventory.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Vehicle v = inventory.get(idx);

        if (v.isRented()) {
            System.out.println("Cannot update price of rented vehicle.");
            return;
        }

        System.out.print("Enter new hourly rate: ");
        double newRate = sc.nextDouble();
        v.setHourlyRate(newRate);

        System.out.println("Price updated!");
    }

    public void rentVehicle() {
        showInventory();
        System.out.print("Enter index to rent: ");
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= inventory.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Vehicle v = inventory.get(idx);

        if (v.isRented()) {
            System.out.println("Vehicle is already taken… just like your crush.");
            return;
        }

        System.out.print("Enter hours: ");
        int hours = sc.nextInt();

        double total = hours * v.getHourlyRate();
        v.setRented(true);

        System.out.println("Please pay ₱" + total + ". Enjoy your " + v.getName() + "!");
    }

    public void returnVehicle() {
        showInventory();
        System.out.print("Enter index to return: ");
        int idx = sc.nextInt() - 1;

        if (idx < 0 || idx >= inventory.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Vehicle v = inventory.get(idx);

        if (!v.isRented()) {
            System.out.println("This vehicle was not rented.");
            return;
        }

        v.setRented(false);
        System.out.println("Thank you for returning the " + v.getName() + "!");
    }
}

public class CarRental {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("[1] Rent Vehicle");
            System.out.println("[2] Update Price");
            System.out.println("[3] View Inventory");
            System.out.println("[4] Add Vehicle");
            System.out.println("[5] Remove Vehicle");
            System.out.println("[6] Return Vehicle");
            System.out.println("[7] Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> system.rentVehicle();
                case 2 -> system.updatePrice();
                case 3 -> system.showInventory();
                case 4 -> system.addVehicle();
                case 5 -> system.removeVehicle();
                case 6 -> system.returnVehicle();
                case 7 -> {
                    System.out.println("Thank you for doing business!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
            sc.close();
        }
    }
}

