package inclass.m3.polymorphism;

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        // TODO 1: Return Math.PI * radius * radius.
        return 0.0;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        // TODO 2: Return side * side.
        return 0.0;
    }
}

/** Canvas Example 2 student starter: interface polymorphism. */
public class InterfacePolymorphismExample {
    public static void main(String[] args) {
        // TODO 3: Store Circle(5.0) in a Shape reference.
        // TODO 4: Store Square(4.0) in a Shape reference.
        // TODO 5: Print both areas.
    }
}
