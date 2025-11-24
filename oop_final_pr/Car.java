class Car extends Vehicle {
    public Car(double rate) { super("Car", rate); }
    @Override
    public String getType() { return "Car"; }
}