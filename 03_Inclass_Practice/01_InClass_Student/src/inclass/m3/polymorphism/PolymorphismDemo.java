package inclass.m3.polymorphism;

/*
* IN-CLASS STUDENT HINTS
* ----------------------
* Focus on object-oriented structure:
* - fields describe object state;
* - constructors initialize objects;
* - methods describe behavior;
* - inheritance reuses/extends behavior;
* - polymorphism lets a parent reference call overridden child behavior.
*/
/** Module 3 practice: inheritance, overriding, and polymorphism. */
public class PolymorphismDemo {
    static class Animal {
        void speak() {
            System.out.println("Animal sound");
        }
    }
    static class Dog extends Animal {
        @Override
        void speak() {
            // TODO: Replace with a dog-specific message.
            System.out.println("TODO: Dog sound");
        }
    }
    public static void main(String[] args) {
        // TODO: Store a Dog object in an Animal reference.
        // TODO: Call speak() and observe which implementation runs.
        /*
        * HINT / ANSWER CHECKPOINT:
        * Animal animal = new Dog();
        * animal.speak();
        *
        * Expected concept: the overridden Dog method runs at runtime.
        */
        System.out.println("Polymorphism starter ready.");
    }
}
