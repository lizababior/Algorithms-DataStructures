public interface BinarySearchTree<T extends Comparable<T>> {

    //Inserts elem into the tree. Duplicates and null are not allowed
    void insert(T elem) throws IllegalArgumentException;

    //Returns the element with the key or null if not found
    T find(T key) throws IllegalArgumentException;

    //Removes the element with the key. Returns true if element has been found
    boolean remove(T key) throws IllegalArgumentException;

    //Returns the number of elements in the tree
    int size();

    //Returns an array representation of the tree in post-order-traversal
    Object[] toArrayPostOrder();

    //Returns an array representation of the tree in in-order-traversal
    Object[] toArrayInOrder();

    //Returns an array representation of the tree in pre-order-traversal
    Object[] toArrayPreOrder();

    //Returns the parent-node of the key. Null if not found
    T getParent(T key) throws IllegalArgumentException;

    //Returns true if the key is the root, false otherwise
    boolean isRoot(T key) throws IllegalArgumentException;

    //True if the key is an internal node, false otherwise
    boolean isInternal(T key) throws IllegalArgumentException;

    //True if the key is an external node, false otherwise
    boolean isExternal(T key) throws IllegalArgumentException;
}