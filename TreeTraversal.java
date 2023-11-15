public class TreeTraversal {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node root;

    public TreeTraversal() {
        root = null;
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node); // Placeholder for visit operation (e.g., print node value)
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            visit(node); // Placeholder for visit operation
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node); // Placeholder for visit operation
        }
    }

    private void visit(Node node) {
        System.out.println(node.value);
    }

    // Main method to test the tree traversals
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("In-order traversal:");
        tree.inOrderTraversal(tree.root);

        System.out.println("\nPre-order traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("\nPost-order traversal:");
        tree.postOrderTraversal(tree.root);
    }
}

/**
 * Depth First Traversals:
 *
 * In-order Traversal (Left, Root, Right):
 * Traverses the left subtree, visits the root node, and finally traverses the right subtree.
 * Used often for binary search trees as it returns nodes in non-decreasing order.
 */

/**
 * Pre-order Traversal (Root, Left, Right):
 * Visits the root node, traverses the left subtree, and then traverses the right subtree.
 * Useful for copying a tree or for getting a prefix expression on an expression tree.
 */

/**
 * Post-order Traversal (Left, Right, Root):
 * Traverses the left subtree, traverses the right subtree, and visits the root node at the end.
 * Used to delete the tree or to get a postfix expression on an expression tree.
 */