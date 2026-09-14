package instructor.inclass.m3.polymorphism;

/**
 * Canvas Example 2 is implemented in polymorphism.java for compatibility with
 * the existing course file. This clearly named version is provided for teaching.
 */
public class InterfacePolymorphismExample {
    public static void main(String[] args) {
        Shape myShape1 = new Circle(5.0);
        Shape myShape2 = new Square(4.0);

        System.out.println("Area of Circle: " + myShape1.area());
        System.out.println("Area of Square: " + myShape2.area());
    }
}
