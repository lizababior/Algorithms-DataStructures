import com.company.QuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void sortCheck() {
        int[] arr = {10, 7, 8, 9, 1, 5, 14, 87, 2};
        int n = arr.length;

        int[] brr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(brr);

        QuickSort.quicksortMot(arr, arr.length, 0, n - 1);

        Assert.assertArrayEquals(brr, arr);
    }

    @Test
    public void sortedInput() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = arr.length;

        int[] brr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(brr);

        QuickSort.quicksortMot(arr, arr.length, 0, n - 1);

        Assert.assertArrayEquals(brr, arr);
    }

    @Test
    public void reversedInput() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int n = arr.length;

        int[] brr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(brr);

        QuickSort.quicksortMot(arr, arr.length, 0, n - 1);

        Assert.assertArrayEquals(brr, arr);
    }


    @Test
    public void emptyInput() {
        int[] arr = {};
        int n = arr.length;

        QuickSort.quicksortMot(arr, arr.length, 0, n - 1);

        int[] brr = {};

        Assert.assertArrayEquals(brr, arr);
    }

    @Test
    public void quickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        int[] brr = Arrays.copyOf(arr, arr.length);
        QuickSort.quicksortMot(arr, arr.length, 0, n - 1);
        Arrays.sort(brr);
        Assert.assertArrayEquals(brr, arr);
    }

}
