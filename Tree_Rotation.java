public class Tree_Rotation {
}

/**
 * Tree Rotation in Binary Search Trees:
 *
 * Purpose:
 * - Maintain balance in BSTs like AVL or Red-Black.
 * - Restructure while preserving BST property.
 *
 * 1. Left Rotation (LL):
 * Rotate node A to its left.
 * Applied when the right subtree of A is heavier.
 *
 * Visualization:
 *      A            B
 *       \          / \
 *        B  -->   A   C
 *         \
 *          C
 *
 * 2. Right Rotation (RR):
 * Rotate node C to its right.
 * Applied when the left subtree of C is heavier.
 *
 * Visualization:
 *        C          B
 *       /          / \
 *      B    -->   A   C
 *     /
 *    A
 *
 * Note:
 * - Combined rotations like Left-Right (LR) or Right-Left (RL) for complex cases.
 * - Update tree properties (like heights in AVL) post-rotation.
 */

