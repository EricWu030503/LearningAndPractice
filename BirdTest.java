// Base class
class Bird {
    // Method for the Bird to sing
    void sing() {
        System.out.println("Tweet! Tweet!");
    }
}

// Subclass
class ShowBird extends Bird {
    // Overriding the sing method for ShowBird
    @Override
    void sing() {
        System.out.println("Melodious tweet!");
    }
}

// A simple test
public class BirdTest {
    public static void main(String[] args) {
        Object o1 = new ShowBird();  // Static type: Object, Dynamic type: ShowBird

        ShowBird fancyBird = ((ShowBird) o1);  // Static type: ShowBird, Dynamic type: ShowBird
        fancyBird.sing();  // Outputs: Melodious tweet!

        Bird regularBird = ((Bird) o1);  // Static type: Bird, Dynamic type: ShowBird
        regularBird.sing();  // Outputs: Melodious tweet! (because of dynamic method selection)

        ((Bird) o1).sing();  // Outputs: Melodious tweet!

        Object o2 = (Bird) o1;  // Static type: Object, Dynamic type: ShowBird

        // o2.sing(); compilation error since we can only call method based on static type
    }
}

/*
Compiler allows memory box to hold any subtype.
Compiler allows calls based on static type.
Overridden non-static methods are selected at run time based on dynamic type.
Everything else is based on static type, including overloaded methods.
 */