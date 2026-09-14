package instructor.inclass.m3.basics;

/** Optional combined runner for the Canvas-aligned Car and Book examples. */
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        car.start();
        car.drive();

        Book book = new Book("Core Java", "Cay Horstmann");
        book.displayInfo();
    }
}
