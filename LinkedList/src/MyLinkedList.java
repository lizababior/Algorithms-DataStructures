import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    private MyListNode<T> head;
    private MyListNode<T> tail;
    private int length;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void addFirst(T elem) throws IllegalArgumentException {
        if (elem == null) throw new IllegalArgumentException();
        MyListNode<T> newNode = new MyListNode(elem);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T elem) throws IllegalArgumentException {
        if (elem == null) throw new IllegalArgumentException();
        if (tail == null) {
            addFirst(elem);
            return;
        }
        MyListNode<T> newNode = new MyListNode<T>(elem);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    @Override
    public void addSorted(T val) {
        this.addFirst(val);
        this.sortASC();
    }

    @Override
    public void sortASC() {
        for (int i = length - 1; i >= 1; i--) {
            MyListNode<T> finalval = head;
            MyListNode<T> tempNode = head;
            for (int j = 0; j < i; j++) {
                MyListNode nextnode = head.getNext();
                if (head.compareTo(nextnode) == 1) {
                    if (head.getNext().getNext() != null) {
                        MyListNode CurrentNext = head.getNext().getNext();
                        nextnode.setNext(head);
                        nextnode.getNext().setNext(CurrentNext);
                        if (j == 0) {
                            finalval = nextnode;
                        } else
                            head = nextnode;
                        for (int l = 1; l < j; l++) {
                            tempNode = tempNode.getNext();
                        }
                        if (j != 0) {
                            tempNode.setNext(nextnode);
                            head = tempNode;
                        }
                    } else if (head.getNext().getNext() == null) {
                        nextnode.setNext(head);
                        nextnode.getNext().setNext(null);
                        for (int l = 1; l < j; l++) {
                            tempNode = tempNode.getNext();
                        }
                        tempNode.setNext(nextnode);
                        nextnode = tempNode;
                        head = tempNode;
                    }
                } else {
                    head = tempNode;
                }
                head = finalval;
                tempNode = head;
                for (int k = 0; k <= j && j < i - 1; k++) {
                    head = head.getNext();
                }
            }
        }
    }

    @Override
    public void sortDES() {
        sortASC();
        reverse();
    }

    private MyListNode<T> reverse() {
        MyListNode<T> prev = null;
        MyListNode<T> current = head;
        MyListNode<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public T removeFirst() {
        MyListNode<T> oldFirst = head;
        if (head == null)
            return null;
        else {
            oldFirst = head;
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            length--;
            return oldFirst.getElement();
        }
    }

    @Override
    public T removeLast() {
        MyListNode<T> temp = head, oldLast = tail;
//        if (head == null || head.getNext() == null) {
//            return null;
//        }
        if (this.size() == 1) {
            this.clear();
        } else {
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            oldLast = tail;
            tail = temp;
            length--;
        }
        return oldLast.getElement();
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        } else {
            return head.getElement();
        }
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        } else {
            return tail.getElement();
        }
    }

    @Override
    public boolean contains(T val) throws IllegalArgumentException {
        if (val == null) throw new IllegalArgumentException();
        MyListNode<T> currNode = head;
        while (currNode != null) {
            if (val.equals(currNode.getElement())) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    @Override
    public T get(int index) {
        MyListNode<T> currNode = head;
        int count = 0;
        while (currNode != null) {
            if (count == index)
                return currNode.getElement();
            count++;
            currNode = currNode.getNext();
        }
        return null;
    }

    @Override
    public T remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("\nIndex should be >= 0.");
        } else if (index == 0 && head != null) {
            MyListNode<T> nodeToDelete = head;
            head = head.getNext();
            length--;
            return nodeToDelete.getElement();
        } else {
            MyListNode<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp != null) {
                    temp = temp.getNext();
                }
            }
            if (temp != null && temp.getNext() != null) {
                MyListNode<T> nodeToDelete = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                length--;
                return nodeToDelete.getElement();
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (head == null) {
            sb.append(']');
            return sb.toString();
        }

        MyListNode<T> currNode = head;
        while (true) {
            sb.append(currNode.getElement());
            if (currNode.getNext() == null) {
                return sb.append(']').toString();
            }
            currNode = currNode.getNext();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size()];
        int i = 0;
        for (MyListNode x = head; x != null; x = x.getNext()) {
            arr[i++] = x.getElement();
        }
        return arr;
    }
}