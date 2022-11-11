import java.util.ArrayList;
import java.util.List;

public class AVLTree<T extends Comparable<T>> {
    protected AVLNode<T> root;
    protected int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    // Returns the number of elements stored in the AVL-tree.
    public int size() {
        return size;
    }

    // Returns the height of the tree in O(1).
    public int height() {
        if (root != null) {
            return root.height;
        }
        return 0;
    }

    // Inserts the element elem into the AVL-tree (null elements are not allowed), duplicates are not allowed
    public void insert(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        root = insertRec(null, root, elem);
        restructure(root);
        size++;
    }

    private AVLNode<T> insertRec(AVLNode<T> parent, AVLNode<T> node, T elem) {
        if (node == null) {
            node = new AVLNode<>(elem);
            node.parent = parent;
            return node;
        }

        if (node.data.compareTo(elem) > 0) {
            node.left = insertRec(node, node.left, elem);
        } else if (node.data.compareTo(elem) < 0) {
            node.right = insertRec(node, node.right, elem);
        } else {
            throw new IllegalArgumentException("Tree already contains a node with key " + elem);
        }
        updateHeights(node);

        return node;
    }

    private void restructure(AVLNode<T> n) {
        int balanceFactor = balanceFactor(n);

        // Left-heavy
        if (balanceFactor > 1) {
            if (balanceFactor(n.left) < 0) {
                n.left = leftRotate(n.left);
            }
            n = rightRotate(n);
        }

        // Right-heavy
        if (balanceFactor < -1) {
            if (balanceFactor(n.right) > 0) {
                n.right = rightRotate(n.right);
            }
            n = leftRotate(n);
        }
    }

    private int balanceFactor(AVLNode<T> n) {
        return n != null ? height(n.left) - height(n.right) : 0;
    }

    private AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> leftChild = node.left;
        leftChild.parent = node.parent;

        node.left = leftChild.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        if (leftChild.parent != null) {
            if (node == leftChild.parent.left) {
                leftChild.parent.left = leftChild;
            } else {
                leftChild.parent.right = leftChild;
            }
        } else {
            root = leftChild;
        }

        updateHeights(node);
        updateHeights(leftChild);

        return leftChild;
    }

    private AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> rightChild = node.right;
        rightChild.parent = node.parent;

        node.right = rightChild.left;
        if (node.right != null) {
            node.right.parent = node;
        }
        rightChild.left = node;
        node.parent = rightChild;

        if (rightChild.parent != null) {
            if (node == rightChild.parent.left) {
                rightChild.parent.left = rightChild;
            } else {
                rightChild.parent.right = rightChild;
            }
        } else {
            root = rightChild;
        }

        updateHeights(node);
        updateHeights(rightChild);

        return rightChild;
    }

    private void updateHeights(AVLNode<T> n) {
        int leftChildHeight = height(n.left);
        int rightChildHeight = height(n.right);
        n.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    // Helper method which returns the height of the subtree n.
    private int height(AVLNode<T> n) {
        return n != null ? n.height : 0;
    }

    // Returns the first element with key, null if it was not found
    public T find(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        AVLNode<T> current = root;
        while (current != null && key != current.data) {
            if (key.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return null;
        }
        return current.data;
    }

    // Removes the first element with the key, returns true if it was found
    public boolean remove(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (key.compareTo(root.data) == 0 && size == 1) {
            root = null;
            size--;
            return true;
        }
        if (remove(root, key) != null) {
            size--;
            return true;
        }
        return false;
    }

    private AVLNode<T> remove(AVLNode<T> node, T key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.data) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.data) > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = findMinimum(node.left);
            node.left = remove(node.left, node.data);
        }

        updateHeights(node);
        restructure(node);
        return node;
    }

    private T findMinimum(AVLNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    // Returns an array representation of the stored elements (Postorder-traversal).
    public Object[] toArray() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        postOrder(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    private void postOrder(AVLNode<T> n, List<Object> arr) {
        if (n == null) {
            return;
        }
        postOrder(n.left, arr);
        postOrder(n.right, arr);
        arr.add(n.data);
    }

}
