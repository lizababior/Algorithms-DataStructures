public class QuickSort {

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    static void swap(int[] array, int i, int j, int p) {
        int tmp = array[i];
        array[i] = p;
        array[j] = tmp;
    }

    public static int partition(int[] array, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex - 1;
        int pivot = array[endIndex];

        while (left <= right) {
            while (left <= right && array[left] <= pivot) {
                ++left;
            }
            while (left <= right && array[right] >= pivot) {
                --right;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, endIndex, pivot);

        return left;
    }

    public static void quicksortMot(int array[], int size, int left, int right) {
        if (left < right) {
            int q = partition(array, left, right);

            quicksortMot(array, array.length, left, q - 1);
            quicksortMot(array, array.length, q + 1, right);
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quicksortMot(arr, arr.length, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
