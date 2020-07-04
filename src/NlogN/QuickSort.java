package NlogN;

import test.SortTestHelper;


public class QuickSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 0, 20000);
        quickSort(array);
        SortTestHelper.printArray(array);
    }


    public static void quickSort(int[] array) {
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("quickSort:" + runTime + "ms");
    }


    //三数中值分割
    private static int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center] < a[left])
            swap(a, left, center);
        if (a[right] < a[left])
            swap(a, left, right);
        if (a[right] < a[center])
            swap(a, center, right);

        // Place pivot at position right - 1
        swap(a, center, right - 1);
        return a[right - 1];
    }
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = median3(array, left, right);
            int i = left, j = right - 1;
            while (true) {
                while (array[++i] < pivot) { }
                while (j>left&&array[--j] > pivot) { }
                if (i < j) {
                    swap(array, i, j);
                } else {
                    break;
                }
            }

            if (i<right){
                swap(array, i, right - 1);
            }

            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
