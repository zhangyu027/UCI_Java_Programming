package instructor.inclass.m3.polymorphism;

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
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

/** Canvas Example 2: interface polymorphism. */
public class polymorphism {
    public static void main(String[] args) {
        Shape myShape1 = new Circle(5.0);
        Shape myShape2 = new Square(4.0);

        System.out.println("Area of Circle: " + myShape1.area());
        System.out.println("Area of Square: " + myShape2.area());
    }
}
