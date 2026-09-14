package instructor.inclass.m3.basics;

/** Canvas-aligned Module 3 basic class example. */
public class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void start() {
        System.out.println(make + " " + model + " is starting.");
    }

    public void drive() {
        System.out.println(make + " " + model + " is driving.");
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        car.start();
        car.drive();
    }
}
