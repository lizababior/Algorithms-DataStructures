import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyLinkedListTest {
    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    MyLinkedList list = new MyLinkedList();

    public int fill(int a, int b) {
        int i;
        for (i = a; i <= b; i++) {
            list.addLast(i);
        }
        return i - 1;
    }

    public void fillInt(MyLinkedList list) {
        for (int i = 10; i >= 1; i--) {
            list.addLast(i);
        }
    }

    public void fillString(MyLinkedList list) {
        list.addFirst("A");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.addLast("B");
    }

    @Test
    public void size() {
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void addFirst() {
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        Assert.assertEquals(2, list.getFirst());
    }

    @Test
    public void addLast() {
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        Assert.assertEquals(10, list.getLast());
    }

    @Test
    public void addSorted() {
        arr.add(11);
        fillInt(list);
        list.addSorted(11);
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(arr.get(i), list.get(i));
        }
    }

    @Test
    public void sortASC() {
        fillInt(list);
        list.sortASC();
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(arr.get(i), list.get(i));
        }
    }

    @Test
    public void sortDES() {
        Collections.reverse(arr);
        fillInt(list);
        list.sortDES();
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(arr.get(i), list.get(i));
        }
    }

    @Test
    public void clear() {
        Assert.assertEquals(fill(1, 10), list.size());
        list.clear();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void removeFirst() {
        fill(1, 10);
        Assert.assertEquals(1, list.removeFirst());
        Assert.assertEquals(2, list.getFirst());
    }

    @Test
    public void removeLast() {
        int a = 1, b = 10;
        fill(a, b);
        Assert.assertEquals(b, list.removeLast());
        Assert.assertEquals(b - 1, list.getLast());
    }

    @Test
    public void getFirst() {
        list.addFirst(0);
        list.addFirst(1);
        Assert.assertEquals(1, list.getFirst());
    }

    @Test
    public void getLast() {
        list.addLast(10);
        list.addLast(9);
        Assert.assertEquals(9, list.getLast());
    }

    @Test
    public void contains() {
        fill(1, 10);
        Assert.assertEquals(true, list.contains(8));
    }

    @Test
    public void get() {
        int a = 1, b = 10;
        fill(a, b);
        list.sortASC();
        Assert.assertEquals(b, list.get(b - 1));
    }

    @Test
    public void remove() {
        int a = 1, b = 10;
        fill(a, b);
        Assert.assertEquals(b, list.size());
        Assert.assertEquals(list.get(3), list.remove(3));
        Assert.assertEquals(b-1, list.size());
    }

    @Test
    public void toStringTest() {
        fill(1, 10);
        Assert.assertEquals(arr.toString(), list.toString());
    }

    @Test
    public void toArray() {
        fillInt(list);
        list.sortASC();
        Object[] objects1 = arr.toArray();
        Object[] objects2 = list.toArray();
        Assert.assertEquals(objects1, objects2);
    }

}
