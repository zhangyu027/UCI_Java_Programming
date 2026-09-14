package instructor.inclass.m3.basics;

/** Optional combined runner for the Canvas-aligned Car and Book examples. */
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2024, 32000.00);
        car.drive();

        Book book = new Book("Core Java", "Cay Horstmann", 928, 59.99);
        book.read();
    }
}
