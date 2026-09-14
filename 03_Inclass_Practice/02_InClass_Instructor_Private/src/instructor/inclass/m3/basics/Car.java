package instructor.inclass.m3.basics;

/** Complete instructor reference based on the Canvas Car starter. */
public class Car {
    private String make;
    private String model;
    private int year;
    private double price;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void drive() {
        System.out.println(year + " " + make + " " + model + " is driving.");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2024, 32000.00);

        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: $" + car.getPrice());

        car.drive();
        car.setPrice(30500.00);
        System.out.println("Updated price: $" + car.getPrice());
    }
}
