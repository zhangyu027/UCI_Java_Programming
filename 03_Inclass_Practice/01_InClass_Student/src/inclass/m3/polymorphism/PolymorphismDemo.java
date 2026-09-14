package inclass.m3.polymorphism;

class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        // TODO 1: Print the dog-specific sound: Woof!
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        // TODO 2: Print the cat-specific sound: Meow!
    }
}

/** Canvas Example 1 student starter: method overriding polymorphism. */
public class PolymorphismDemo {
    public static void main(String[] args) {
        // TODO 3: Create an Animal reference containing a Dog object.
        // TODO 4: Create an Animal reference containing a Cat object.
        // TODO 5: Call makeSound() on both references.
    }
}
