package instructor.inclass.m3.polymorphism;
interface ShapeLegacy {
    double area();
}
class CircleLegacy implements ShapeLegacy {
    double r;
    CircleLegacy(double r) {
        this.r=r;
    }
    public double area() {
        return Math.PI*r*r;
    }
}
class RectangleLegacy implements ShapeLegacy {
    double w, h;
    RectangleLegacy(double w, double h) {
        this.w=w;
        this.h=h;
    }
    public double area() {
        return w*h;
    }
}
public class polymorphism {
    public static void main(String[]a) {
        ShapeLegacy[] s= {
          new CircleLegacy(2), new RectangleLegacy(3, 4)   
        };
        for (ShapeLegacy x:s)System.out.printf("Area=%.2f%n", x.area());
    }
}


