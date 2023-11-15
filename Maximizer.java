import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

/*
interface Comparable<T> {
    public int compareTo(T obj);
} no need to implement this interface, this is a Java built-in interface
 */

/*
public interface Comparator<T> {
    int compare(T o1, T o2);
} no need to implement this interface, this is a Java built-in interface
 */


class Mouse implements Comparable<Mouse> {
    private String name;
    private int size;

    // Constructor to initialize the name and size of the mouse.
    public Mouse(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Mouse s) {
        return this.size - s.size;
    }

    private static class NameComparator implements Comparator<Mouse> {
        public int compare(Mouse a, Mouse b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Mouse> getNameComparator() {
        return new NameComparator();
    }

    public void squeak() {
        System.out.println(name + " squeaks!");
    }
}


public class Maximizer {
    public static Comparable max(Comparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args) {
        Mouse[] mice = {new Mouse("Elyse", 3), new Mouse("Sture", 9),
                new Mouse("Benjamin", 15)};
        Mouse maxMouse = (Mouse) Maximizer.max(mice);
        maxMouse.squeak();

        Mouse m1 = new Mouse("Elyse", 3);
        Mouse m2 = new Mouse("Sture", 9);
        Mouse m3 = new Mouse("Benjamin", 15);

        Mouse[] mice2 = new Mouse[]{m1, m2, m3};
        Mouse largestMouse = Collections.max(Arrays.asList(mice2));
        largestMouse.squeak();

        Comparator<Mouse> nc = Mouse.getNameComparator();
        if (nc.compare(m1, m3) > 0) { // if m1 comes later than m3 in the alphabet
            m1.squeak();
        } else {
            m3.squeak();
        }

    }
}


