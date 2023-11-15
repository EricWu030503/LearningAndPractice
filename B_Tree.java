import java.util.ArrayList;
import java.util.List;

public class B_Tree {
    private static final int T = 3; // Degree of the B-tree
    private Node root;

    private class Node {
        int n; // Number of keys currently stored in the node
        boolean leaf;
        List<Integer> keys = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        Node() {
            leaf = true;
            n = 0;
            for (int i = 0; i < 2 * T - 1; i++) {
                keys.add(null);
                if (i < 2 * T) {
                    children.add(null);
                }
            }
        }
    }

    public B_Tree() {
        root = new Node();
    }

    public void insert(int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.children.set(0, r);
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void splitChild(Node x, int i) {
        Node z = new Node();
        Node y = x.children.get(i);
        z.leaf = y.leaf;
        z.n = T - 1;
        for (int j = 0; j < T - 1; j++) {
            z.keys.set(j, y.keys.get(j + T));
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.children.set(j, y.children.get(j + T));
            }
        }
        y.n = T - 1;
        x.children.add(i + 1, z);
        x.keys.add(i, y.keys.get(T - 1));
        x.n = x.n + 1;
    }

    private void insertNonFull(Node x, int k) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && k < x.keys.get(i)) {
                x.keys.set(i + 1, x.keys.get(i));
                i--;
            }
            x.keys.set(i + 1, k);
            x.n = x.n + 1;
        } else {
            while (i >= 0 && k < x.keys.get(i)) {
                i--;
            }
            i++;
            if (x.children.get(i).n == 2 * T - 1) {
                splitChild(x, i);
                if (k > x.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(x.children.get(i), k);
        }
    }


    public boolean search(int k) {
        return search(root, k);
    }

    private boolean search(Node x, int k) {
        int i = 0;
        while (i < x.n && k > x.keys.get(i)) {
            i++;
        }
        if (i < x.n && k == x.keys.get(i)) {
            return true;
        } else if (x.leaf) {
            return false;
        } else {
            return search(x.children.get(i), k);
        }
    }
}




/**
 * B-Tree Introduction:
 *
 * Definition:
 * - B-tree is a self-balancing tree structure that maintains sorted data, permitting logarithmic time complexities for searches, additions, and deletions.
 *
 * Naming Rule:
 * - B-Trees are often named according to the maximum number of children a node can have. A "2-3 tree" can have 2 or 3 children, while a "2-3-4 tree" can have 2, 3, or 4 children.
 *
 * Key Properties:
 * 1. All leaves have the same depth, ensuring balance in the tree.
 * 2. A node with k keys will have k+1 children.
 * 3. The keys in a node act as separators that determine which of the k+1 child pointers the search should follow based on value comparisons:
 *    - Smaller values go to the left.
 *    - Greater values go to the right.
 *    For instance, if we have keys K1 < K2 and we are looking for a value X;
 *    - If X < K1, take the leftmost child.
 *    - If K1 < X < K2, take the second child.
 *    - If X > K2, take the rightmost child.
 *
 * Add Operation:
 * 1. Start at the root.
 * 2. Locate the node for the new key based on value comparisons, and traverse to the appropriate child node:
 *    - Smaller values traverse left.
 *    - Greater values traverse right.
 * 3. If the node isn't full (contains fewer than L keys), add the key.
 * 4. If a node gets full (having L keys):
 *    - Split the node.
 *    - For even number of keys, the left of the two middle keys is the "middle" key.
 *    - For odd, the central key is the "middle" key.
 *    - The "middle" key moves up to its parent.
 *    - Keys less than the "middle" key remain in the left child, greater ones go to the right.
 * 5. If this causes the parent to be full, recursively split up to the root.
 * 6. If the root is full post-split, the "middle" key becomes the new root.
 *
 * Complexity and Application:
 * - B-tree operations (search, add, delete) have O(log N) time(disregard of the insertion order).
 * - In contexts of:
 *   1. Small L (2 or 3): Used conceptually for balanced trees.
 *   2. Large L (e.g., thousands): For databases or filesystems with massive records.
 * - Its structure minimizes disk I/O operations.
 * - B-Tree properties ensure bushiness, maintaining logarithmic operation performance.
 */

