import com.company.MinHeap;
import com.company.QuickSort;
import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class HeapTest {
    MinHeap intHeap = new MinHeap(7);

    private void fillInt(int n) {
        for (int i = 0; i < n; i++) {
            intHeap.insert(i);
        }
    }

    @Test
    public void constructor() {
        Integer[] arr = new Integer[7];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        MinHeap heap = new MinHeap<>(arr);

        Integer[] brr = new Integer[0];
        MinHeap heap2 = new MinHeap<>(brr);
        heap2.insert(8);

        MinHeap heap3 = new MinHeap<>(0);
        heap3.insert(8);
    }

    @Test
    public void sort() {
        Integer[] arr = new Integer[7];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Integer[] brr = Arrays.copyOf(arr, arr.length);
        MinHeap.sort(arr);
        Arrays.sort(brr);
        Collections.reverse(Arrays.asList(brr));
        Assert.assertArrayEquals(brr, arr);
    }

    @Test
    public void contains() {
        intHeap.insert(1);
        intHeap.insert(5);
        intHeap.insert(3);
        intHeap.insert(6);
        intHeap.insert(8);
        intHeap.insert(9);
        intHeap.insert(4);

        int n = 1;
        Assert.assertEquals(true, intHeap.contains(n));
        n = 0;
        Assert.assertEquals(false, intHeap.contains(n));
        n = 5;
        Assert.assertEquals(true, intHeap.contains(n));
        n = 3;
        Assert.assertEquals(true, intHeap.contains(n));
        n = 30;
        Assert.assertEquals(false, intHeap.contains(n));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            intHeap.contains(null);
        });
        String expectedMessage = "Null value is not allowed";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        Assert.assertEquals(false, intHeap.contains(Integer.MIN_VALUE));
    }
}
