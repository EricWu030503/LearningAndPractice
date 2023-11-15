import java.util.Random;

public class BST {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    // Insert a value to the BST
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Find a value in the BST
    public boolean find(int value) {
        return findRecursive(root, value) != null;
    }

    private Node findRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            return current;
        }

        return value < current.value ? findRecursive(current.left, value) : findRecursive(current.right, value);
    }

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // Case 1: No children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only one child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: Two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }
        else if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        else {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
}

/**
 * Binary Tree:
 * - A tree structure where each node has at most two children(0,1,2), typically referred to as the left child and the right child.
 */


/**
 * Rooted Tree:
 * - A tree in which one designated node is considered the root.
 * - From this root, there is an implicit direction towards its descendants, establishing parent-child relationships.
 * - Every node, except the root, has one and only one parent. A node with no child is called a leaf.
 */


/**
 A binary search tree is a rooted binary tree with the BST property.

 BST Property. For every node X in the tree:
 1. Every key in the left subtree is less than X’s key.
 2. Every key in the right subtree is greater than X’s key.

 No duplicate keys allowed

 BSTs have best case height Θ(log N), and worst case height Θ(N).

 BST is a fundamental structure behind Tree Set, and Tree Map could be constructed by making each node in the tree a key-value pair
 */

/**
 * 1. Depth of a Node:
 *    - Definition: The depth of a node is the number of edges from the tree's root to the node.
 *                  The root node has a depth of 0, its immediate children have a depth of 1, and so on.
 *    - Significance: The depth of a node can influence the time it takes to access or find that node,
 *                    especially in operations like `get` or `contains`.
 *
 * 2. Height of a BST:
 *    - Definition: The height of a BST (or any tree) is the number of edges on the longest path from the
 *                  root node to a leaf. It's also known as the depth of the deepest node or the maximum depth.
 *    - Significance: The height of the BST is crucial for performance. Many basic operations (like `get`,
 *                    `put`, `contains`) have a time complexity that is proportional to the height of the tree.
 *                    In a balanced BST, the height is O(log n), where n is the number of nodes. However, in the
 *                    worst case, the BST can become like a linked list, making its height O(n).
 *
 * 3. Average Depth:
 *    - Definition: The average depth of a BST is the average of the depths of all nodes in the BST.
 *                  To compute it, you'd sum up the depths of all nodes and then divide by the total number of nodes.
 *    - Significance: The average depth can give a more holistic view of the tree's structure than just the height.
 *                    A tree could have a large height but a relatively small average depth if most nodes are closer
 *                    to the root and only a few nodes are far away.
 */




