import java.util.*;
public class ArraySet<T> implements Iterable<T>{

    /** returns an iterator (a.k.a. seer) into ME */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }


    private T[] items;
    private int size;

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }

        if (other instanceof ArraySet otherSet) {
            if (this.size != otherSet.size) {
                return false;
            }
            for (T x : this) {
                if (!otherSet.contains(x)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void add(T x) {
        if (!contains(x)) {
            items[size] = x;
            size += 1;
        }
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) { // equals() is a function in object class used for reference comparison but is usually overridden(such as in String class)
                return true;
            }
        }
        return false;
    }

    @Override //it is override because object class also has a toString method
    public String toString() {
        String returnString = "{";
        for (T item : this) {
            returnString += item.toString();
            returnString += ", ";
        }
        returnString += "}";
        return returnString;
    }
    /*
    @Override
    public String toString() {
       StringBuilder returnSB = new StringBuilder("{");
       for (int i = 0; i < size; i += 1) {
           returnSB.append(items[i]);
           returnSB.append(", ");
       }
       returnSB.append("}");
       return returnSB.toString();
    } this is a much faster method
     */

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        Iterator<Integer> aseer = aset.iterator();

        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }
    }

}


/*
To support the enhanced for loop:
Add an iterator() method to your class that returns an Iterator<T>.
The Iterator<T> returned should have a useful hasNext() and next() method.
Add implements Iterable<T> to the line defining your class.
 */