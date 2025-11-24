import java.util.ArrayList;
import java.util.Scanner;

class RentalSystem {
    private ArrayList<Vehicle> inventory = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public RentalSystem() {
        inventory.add(new Bicycle(10));
        inventory.add(new Car(50));
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("[1] Rent Vehicle");
            System.out.println("[2] Update Price");
            System.out.println("[3] Show Inventory");
            System.out.println("[4] Add Vehicle");
            System.out.println("[5] Remove Vehicle");
            System.out.println("[6] Return Vehicle");
            System.out.println("[7] Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            if (choice == 7) { System.out.println("Thank you!"); sc.close(); return; }

            switch (choice) {
                case 1 -> rentOrReturn(true);
                case 6 -> rentOrReturn(false);
                case 2 -> updatePrice();
                case 3 -> showInventory();
                case 4 -> addVehicle();
                case 5 -> removeVehicle();
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void rentOrReturn(boolean rent) {
        showInventory();
        System.out.print("Enter vehicle number: ");
        int i = sc.nextInt() - 1; sc.nextLine();
        if (i < 0 || i >= inventory.size()) { System.out.println("Invalid number."); return; }
        Vehicle v = inventory.get(i);
        if (rent) {
            if (!v.isRented()) { v.setRented(true); System.out.println("Rented " + v.getName() + "!"); }
            else System.out.println("Already rented.");
        } else {
            if (v.isRented()) { v.setRented(false); System.out.println("Returned " + v.getName() + "!"); }
            else System.out.println("Not rented.");
        }
    }

    private void showInventory() {
        System.out.println("\n--- Inventory ---");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print("[" + (i + 1) + "] "); inventory.get(i).printInfo();
        }
    }

    private void addVehicle() {
        System.out.print("Type (Car/Bicycle): "); String type = sc.nextLine();
        System.out.print("Hourly rate: "); double rate = sc.nextDouble(); sc.nextLine();
        if (type.equalsIgnoreCase("Car")) inventory.add(new Car(rate));
        else if (type.equalsIgnoreCase("Bicycle")) inventory.add(new Bicycle(rate));
        else { System.out.println("Invalid type."); return; }
        System.out.println(type + " added!");
    }

    private void removeVehicle() {
        showInventory();
        System.out.print("Vehicle number to remove: "); int i = sc.nextInt() - 1; sc.nextLine();
        if (i < 0 || i >= inventory.size()) { System.out.println("Invalid number."); return; }
        System.out.println(inventory.remove(i).getName() + " removed!");
    }

    private void updatePrice() {
        showInventory();
        System.out.print("Vehicle number: "); int i = sc.nextInt() - 1; sc.nextLine();
        if (i < 0 || i >= inventory.size()) { System.out.println("Invalid number."); return; }
        System.out.print("New hourly rate: "); double rate = sc.nextDouble(); sc.nextLine();
        inventory.get(i).setHourlyRate(rate);
        System.out.println("Price updated!");
    }
}

