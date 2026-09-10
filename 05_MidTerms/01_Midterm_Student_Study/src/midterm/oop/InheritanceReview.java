package midterm.oop;

/*
 * STUDENT STUDY GUIDE — Inheritance & Polymorphism
 * ------------------------------------------------
 * Concepts to review:
 * 1. Create a parent class.
 * 2. Create a child class using inheritance.
 * 3. Override a method from the parent class.
 * 4. Use a parent reference to hold a child object.
 * 5. Predict which version of the overridden method runs.
 *
 * CHECKPOINT:
 * Be able to explain:
 * - What does "extends" mean?
 * - What does @Override mean?
 * - Why can a parent reference point to a child object?
 * - Which speak() method is called at runtime?
 */

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
