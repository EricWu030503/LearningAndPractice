// Define an interface
interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal myAnimal; // 'myAnimal' has a static type/compile time type of 'Animal', the type specified at declaration. Never changes!

        myAnimal = new Dog(); // The dynamic type/run time type is 'Dog'
        myAnimal.speak(); // Outputs: Woof!
        // myAnimal will use the speak method in Dog class, namely its dynamic type, this is called dynamic method selection

        myAnimal = new Cat(); // The dynamic type/run time type is now 'Cat', the type specified at instantiation
        myAnimal.speak(); // Outputs: Meow

        Cat c = new Cat();
        ((Animal) c).speak(); // Outputs: Meow! The static type here is type casted to Animal. However, the dynamic type is still Cat, which means c still points to a Cat object.

        // c = myAnimal; compilation error here
        c = (Cat) myAnimal;

        /*
        If Animal is a class,
        Animal a = new Animal() // note that this doesn't work here because interface instantiation is not allowed
        ((Cat) a).speak() // this will compile, since animal could possibly be a cat. However, it will cause run-time error since Java finds out that a points to Animal object instead of Cat object at run time
         */
    }
}
// Java automatically selects the right behavior using what is sometimes called “dynamic method selection”.