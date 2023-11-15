import java.util.ArrayList;

/** (Min) Priority Queue: Allowing tracking and removal of the
 * smallest item in a priority queue. */
public interface MinPQ<Item> {
    /** Adds the item to the priority queue. */
    public void add(Item x);
    /** Returns the smallest item in the priority queue. */
    public Item getSmallest();
    /** Removes the smallest item from the priority queue. */
    public Item removeSmallest();
    /** Returns the size of the priority queue. */
    public int size();
}



class MinPriorityQueue<Item extends Comparable<Item>> implements MinPQ<Item> {
    private ArrayList<Item> heap;

    public MinPriorityQueue() {
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        Item temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void swim(int k) {
        while (k > 0 && heap.get((k - 1) / 2).compareTo(heap.get(k)) > 0) {
            swap((k - 1) / 2, k);
            k = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        int leftChild = 2 * k + 1;
        int rightChild = 2 * k + 2;
        int smallest = k;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != k) {
            swap(k, smallest);
            sink(smallest);
        }
    }

    @Override
    public void add(Item x) {
        heap.add(x);
        swim(heap.size() - 1);
    }

    @Override
    public Item getSmallest() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Item removeSmallest() {
        if (heap.isEmpty()) return null;
        Item min = heap.get(0);
        Item lastItem = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            sink(0);
        }
        return min;
    }

    @Override
    public int size() {
        return heap.size();
    }
}


/**
 * Binary Min Heap
 *
 * A binary tree that is complete and obeys the min-heap property.
 *
 * Min-heap property: Every node is less than or equal to both of its children.
 *
 * Completeness: Missing items only at the bottom level (if any),
 * and all nodes are as far left as possible.
 */
