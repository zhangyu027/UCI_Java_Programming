package midterm.oop;

class Animal {
    String speak() {
        return "sound";
    }
}
class Dog extends Animal {
    @Override String speak() {
        return "bark";
    }
}
public class InheritanceReview {
    public static void main(String[]a) {
        Animal x=new Dog();
        System.out.println(x.speak());
    }
}
