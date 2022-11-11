public interface MyHashSet {
    // Returns the number of stored keys (these must be unique).
    public int size();

    // Inserts the key into the set and returns true if it was inserted, false otherwise.
    public boolean insert(Object key) throws IllegalArgumentException;

    // Returns true if the key is included in the set false otherwise.
    public boolean contains(Object key) throws IllegalArgumentException;

    // Removes the key from the set and returns true if it was removed, false otherwise.
    public boolean remove(Object key) throws IllegalArgumentException;

    // Returns a string representation with indication of the array indices (the current structure should be recognizable).
    public String toString();

    // Removes all elements from the set.
    public void clear();
}
