import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public MyBinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (containsKey(elem)) {
            throw new IllegalArgumentException("Duplicates are not allowed");
        }
        root = insertRec(root, elem);
        size++;
    }

    private BinaryTreeNode<T> insertRec(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            root = new BinaryTreeNode<>(key);
            return root;
        }

        if (root.getData().compareTo(key) > 0) {
            root.setLeft(insertRec(root.getLeft(), key));
        } else if (root.getData().compareTo(key) < 0) {
            root.setRight(insertRec(root.getRight(), key));
        }

        return root;
    }

    @Override
    public T find(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (!containsKey(key)) {
            return null;
        }
        return key;
    }

    private boolean containsKey(T key) {
        return getNodeByKey(root, key) != null;
    }

    private BinaryTreeNode<T> getNodeByKey(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getData().equals(key)) {
            return root;
        }
        if (root.getData().compareTo(key) > 0) {
            return getNodeByKey(root.getLeft(), key);
        }
        return getNodeByKey(root.getRight(), key);
    }

    @Override
    public boolean remove(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (remove(root, key) != null) {
            size--;
            return true;
        }
        return false;
    }

    private BinaryTreeNode<T> remove(BinaryTreeNode<T> node, T key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.getData()) < 0) {
            node.setLeft(remove(node.getLeft(), key));
        } else if (key.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(findMinimum(node.getLeft()));
            node.setLeft(remove(node.getLeft(), node.getData()));
        }
        return node;
    }

    private T findMinimum(BinaryTreeNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArrayPostOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        PostOrderRec(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void PostOrderRec(BinaryTreeNode<T> n, List<Object> arr) {
        if (n == null) {
            return;
        }
        PostOrderRec(n.getLeft(), arr);
        PostOrderRec(n.getRight(), arr);
        arr.add(n.getData());
    }

    @Override
    public Object[] toArrayInOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        printInOrder(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void printInOrder(BinaryTreeNode<T> n, List<Object> arr) {
        if (n == null) {
            return;
        }
        printInOrder(n.getLeft(), arr);
        arr.add(n.getData());
        printInOrder(n.getRight(), arr);
    }

    @Override
    public Object[] toArrayPreOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        printPreOrder(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void printPreOrder(BinaryTreeNode<T> n, List<Object> arr) {
        if (n == null) {
            return;
        }
        arr.add(n.getData());
        printPreOrder(n.getLeft(), arr);
        printPreOrder(n.getRight(), arr);
    }

    @Override
    public T getParent(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (!containsKey(key)) {
            return null;
        }
        return findParentRec(root, key);
    }

    private T findParentRec(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        } else if ((root.getRight() != null && root.getRight().getData() == key)
                || (root.getLeft() != null && root.getLeft().getData() == key)) {
            return root.getData();
        } else {
            T found = findParentRec(root.getRight(), key);
            if (found == null) {
                found = findParentRec(root.getLeft(), key);
            }
            return found;
        }
    }

    @Override
    public boolean isRoot(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (!containsKey(key)) {
            return false;
        }
        return getParent(key) == null;
    }

    @Override
    public boolean isInternal(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (!containsKey(key)) {
            return false;
        }
        return getNodeByKey(root, key).getLeft() != null || getNodeByKey(root, key).getRight() != null;
    }

    @Override
    public boolean isExternal(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (!containsKey(key)) {
            return false;
        }
        return getNodeByKey(root, key).getLeft() == null && getNodeByKey(root, key).getRight() == null;
    }
}
