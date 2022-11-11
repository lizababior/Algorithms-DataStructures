import java.util.Arrays;

public class ChainingHashSet<T extends Comparable<T>> implements MyHashSet {

    private static class ChainingHashNode {
        private Object key;
        private ChainingHashNode next;

        ChainingHashNode(Object o) {
            this.key = o;
            this.next = null;
        }

        public Object getKey() {
            return key;
        }

        public ChainingHashNode getNext() {
            return next;
        }

        public void setNext(ChainingHashNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "";
        }
    }

    private ChainingHashNode[] array;
    private int size;

    public ChainingHashSet() {
        this.array = new ChainingHashSet.ChainingHashNode[7];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean insert(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            int hash = hash(key);
            if (!contains(key)) {
                ChainingHashNode newNode = new ChainingHashNode(key);
                newNode.setNext(array[hash]);
                array[hash] = newNode;
                size++;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    @Override
    public boolean contains(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            int hash = hash(key);
            ChainingHashNode current = array[hash];
            while (current != null) {
                if (current.getKey().equals(key)) {
                    return true;
                }
                current = current.getNext();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode()) % array.length;
    }

    @Override
    public boolean remove(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            int h = hash(key);

            if (array[h] != null) {
                if (array[h].getKey().equals(key)) {
                    array[h] = array[h].getNext();
                    size--;
                    return true;
                } else {
                    ChainingHashNode current = array[h];
                    while (current.getNext() != null &&
                            !current.getNext().getKey().equals(key)) {
                        current = current.getNext();
                    }
                    if (current.getNext() != null) {
                        current.setNext(current.getNext().getNext());
                        size--;
                        return true;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chaining HashSet\n");
        sb.append("index  key\n");
        for (int i = 0; i < array.length; i++) {
            sb.append(i + "      ");
            ChainingHashNode node = array[i];
            if (node == null) {
                sb.append("null\n");
                //System.out.printf("%6s\n", "null");
            } else {
                boolean first = true;
                while (node != null) {
                    if (!first) {
                        sb.append(" --> ");
                    }
                    sb.append(node);
                    node = node.getNext();
                    first = false;
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(array, null);
    }
}
