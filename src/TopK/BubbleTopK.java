package TopK;

import test.SortTestHelper;

public class BubbleTopK {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        bubbleSort(array, 5);
        for (int i = array.length - 1; i > array.length - 6; i--) {
            System.out.print(array[i]+" ");
        }
    }

    public static void bubbleSort(int[] array, int k) {
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
