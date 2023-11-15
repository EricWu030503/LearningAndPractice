public interface List61B<T> {
    public void insert(T x, int position);
    public void addFirst(T x);
    public void addLast(T y);
    public T getFirst();
    public T getLast();
    public T removeLast();
    public T get(int i);
    public int size();

    /** Prints out the entire list. */
    default public void print() { // use default key word for method implementation in the interface
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}

// Interface is a specification of what a List is able to do, not how to do it.
// Interfaces cannot be instantiated. (ie. Friendly f = new Friendly(); does not compile)

class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public static IntList reverse(IntList lst) {
        IntList prev = null;
        IntList current = lst;
        IntList next = null;

        while (current != null) {
            // Move the 'next' pointer to the next node
            next = current.rest;

            // Change the current 'rest' pointer
            current.rest = prev;

            // Move the 'prev' and 'current' pointers one step forward
            prev = current;
            current = next;
        }
        return prev;
    }


    public static IntList[] partition(IntList lst, int k) {
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = reverse(lst);
        while (L != null) {
            IntList prevAtIndex = array[index];
            IntList next = L.rest;
            array[index] = L;
            array[index].rest = prevAtIndex;
            L = next;
            index = (index + 1) % array.length;
        }
        return array;
    }


    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(2));
    }

}

class AList<T> implements List61B<T>{ //tell the Java compiler that AList is hyponym of List61B.
    // subclass must override all the non-default methods provided in the interface
    private T[] items;
    private int size;

    /** Creates an empty list. */
    @SuppressWarnings("unchecked")
    public AList() {
        items = (T[]) new Object[100];  // Java doesn't allow generic array creation directly
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }


    @Override // The only effect of this tag is that the code won’t compile if it is not actually an overriding method.
    public void addFirst(T x) {
        insert(x, 0);
    }


    @Override // If a “subclass” has a method with the exact same signature as in the “superclass”, we say the subclass overrides the method.
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return items[0];
    }

    /** Inserts x into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        if (i >= items.length || i < 0) {
            throw new IllegalArgumentException();
        }
        return items[i];
    }

    /** Deletes item from back of list and returns deleted item. */
    public T removeLast() {
        T x = getLast();
        items[size-1] = null;  // Use null for generics, not 0
        size = size - 1;
        return x;
    }

    public void insert(T x, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        // If the list is full, resize it
        if (size == items.length) {
            resize(size * 2);
        }

        // Shift elements to the right of the specified position
        for (int i = size; i > position; i--) {
            items[i] = items[i - 1];
        }

        // Insert the new item
        items[position] = x;
        size += 1;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }
}

class SLList<T> implements List61B<T>{ // tell the Java compiler that SLList is hyponym of List61B.

    private class Node { // nested class
        public T item;
        public Node next;

        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    } // Nested Classes are useful when a class doesn’t stand on its own and is obviously subordinate to another class.

    private Node sentinel;
    private int size; // keep track of the size of the list so that the time complexity of size() function is always constant

    public SLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public SLList() { // second constructor; create an empty list
        sentinel = new Node(null, null);
        size = 0;
    }

    @Override
    public void insert(T x, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        Node p = sentinel;
        while (position > 0) {
            p = p.next;
            position--;
        }

        p.next = new Node(x, p.next);
        size++;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size ++;
    }

    /** Returns the first item in the list. */
    public T getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(T x) {
        Node p = sentinel;

        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(x, null);
        size ++;
    }

    @Override
    public T getLast() {
        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        if (p != sentinel) {
            return p.item;
        }

        return null;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        Node p = sentinel;

        while (p.next.next != null) {
            p = p.next;
        }

        T lastItem = p.next.item;
        p.next = null;
        size--;

        return lastItem;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        Node p = sentinel.next;

        while (i > 0) {
            p = p.next;
            i--;
        }

        return p.item;
    }

    public int iterative_size(){
        Node p = sentinel.next;
        if (p == null){
            return 0;
        }
        int size = 1;
        while (p.next != null){
            p = p.next;
            size ++;
        }
        return size;
    }

    private int size(Node p) { // helper method, since SLList itself is not a recursive structure
        if (p.next == null) {
            return 0;
        }

        return 1 + size(p.next);
    }

    // method overloading
    public int size() {
        return size(sentinel);
    }

    public int fast_size(){
        return size;
    }

    /* A print method that overrides
     List61B's inefficient print method. */
    @Override
    public void print() {
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
    }


    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst()); // should print 5
        System.out.println(L.size());
        System.out.println(L.iterative_size());
        System.out.println(L.fast_size());

        SLList<String> L2 = new SLList<>();
        System.out.println(L2.size());
        System.out.println(L2.iterative_size());
        System.out.println(L2.fast_size());
    }

}

class VengefulSLList<Item> extends SLList<Item> { // extends should only be used in is-a relationship, not has-a relationship
    private SLList<Item> deletedItems;

    public VengefulSLList() {
        super(); // This calls the constructor of SLList. It can be omitted if and only if the constructor has no arguments
        deletedItems = new SLList<Item>();
    }

    public VengefulSLList(Item x) {
        super(x); // cannot be omitted. note that the parent class should have a constructor with one argument of generic type, otherwise it will cause error
        // if we forget to call super(x) here. Java will still call super() implicitly
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item oldBack = super.removeLast(); //super keyword refers to the super class of the current class
        deletedItems.addLast(oldBack);
        return oldBack;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);    /* [1, 5, 10, 13] */
        vs1.removeLast();   /* 13 gets deleted. */
        vs1.removeLast();   /* 10 gets deleted. */
        System.out.print("The fallen are: ");
        vs1.printLostItems(); /* Should print 10 and 13. */

        VengefulSLList<Integer> vsl = new VengefulSLList<Integer>(9);
        SLList<Integer> sl = vsl;
        sl.addLast(50);
        sl.removeLast(); // use the override method in VengefulSLList
        //sl.printLostItems(); compilation error, Java only allows you to use the methods defined in its static type, regardless of the actual object it points to
        // VengefulSLList<Integer> vsl2 = sl; compilation error, not all SLList are VengefulSLList, even though in this particular case sl points to a VengefulSLList object
        VengefulSLList<Integer> vsl2 = (VengefulSLList<Integer>) sl; // use an explicit type-casting to solve this problem
        // type casting will fail at run time (but it will compile) if sl doesn't point to a VengefulSLList object

    }

}

class RotatingSLList <Item> extends SLList<Item>{
    /** Rotates list to the right. */
    public void rotateRight() {
        Item x = removeLast();
        addFirst(x);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rsl = new RotatingSLList<>();
        /* Creates SList: [10, 11, 12, 13] */
        rsl.addLast(10);
        rsl.addLast(11);
        rsl.addLast(12);
        rsl.addLast(13);

        /* Should be: [13, 10, 11, 12] */
        rsl.rotateRight();
        rsl.print();
    }

}
/*
Because of extends, RotatingSLList inherits all members of SLList:
All instance and static variables.
All methods.
All nested classes.
Constructors are not inherited.
But members may be private and thus inaccessible!
*/

class DLList<T> { // generic type in java only supports reference types
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private final Node sentinel;
    private int size;

    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) return null;
        Node firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if (size == 0) return null;
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size--;
        return lastNode.item;
    }

    public void removeDuplicates(){
        Node ref = sentinel.next;
        Node checker;
        while (ref != sentinel) {
            checker = ref.next;
            while (checker != sentinel) {
                if (ref.item == checker.item) {
                    Node checkerPrev = checker.prev;
                    Node checkerNext = checker.next;
                    checkerPrev.next = checker.next;
                    checkerNext.prev = checker.prev;
                    checker = checkerNext;
                } else {
                    checker = checker.next;
                }
            }
            ref = ref.next;
        }
    }

    public T getFirst() {
        return (size == 0) ? null : sentinel.next.item; // conditional (ternary) operator
    }

    public T getLast() {
        return (size == 0) ? null : sentinel.prev.item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(0);
        System.out.println(list.getFirst()); // 2
        System.out.println(list.getLast());  // 0
        System.out.println(list.removeFirst()); // 2
        System.out.println(list.removeLast());  // 0
        System.out.println(list.size());    // 1
    }
}