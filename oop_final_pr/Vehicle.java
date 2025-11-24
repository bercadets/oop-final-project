abstract class Vehicle {
    private String name;
    private double hourlyRate;
    private boolean rented = false;

    public Vehicle(String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public abstract String getType();

    public String getName() { return name; }
    public double getHourlyRate() { return hourlyRate; }
    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }
    public void setHourlyRate(double rate) { this.hourlyRate = rate; }

    public void printInfo() {
        System.out.println(getType() + ": " + name + " | Rate: " + hourlyRate + " | Rented: " + rented);
    }
}