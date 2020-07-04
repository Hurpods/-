package TopK;

import test.SortTestHelper;


public class QuickSelect {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        getTopK(array, 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void getTopK(int[] array, int k) {
        partitionArray(array, 0, array.length - 1, k);
    }

    private static void partitionArray(int[] array, int low, int high, int k) {
        int m = partition(array, low, high);
        if (k == m) return;
        else if (k < m) partitionArray(array, low, m - 1, k);
        else partitionArray(array, m + 1, high, k);
    }

    private static int partition(int[] array, int low, int high) {
        int i = low, j = high + 1;
        int pivot = array[low];
        while (true) {
            while (array[++i] > pivot) {
                if (i == high) break;
            }
            while (array[--j] < pivot) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array,low,j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
