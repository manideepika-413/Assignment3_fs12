// Animal class
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }

    void eat() {
        System.out.println("Animal eats food");
    }
}

// Dog class, inheriting from Animal
class Dog extends Animal {
    // Method overriding
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    // Method overloading
    void eat(String food) {
        System.out.println("Dog eats " + food);
    }

    void eat(String food, int quantity) {
        System.out.println("Dog eats " + quantity + " " + food);
    }
}

public class MethodsDemo {
    public static void main(String[] args) {
        // Method Overriding
        Animal genericAnimal = new Animal();
        genericAnimal.sound();  
        genericAnimal.eat();    

        System.out.println();

        Dog myDog = new Dog();
        myDog.sound();        
        myDog.eat();            
        myDog.eat("bones");     
        myDog.eat("bones", 2);  
    }
}
