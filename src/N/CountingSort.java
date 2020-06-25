package N;

import test.SortTestHelper;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 0, 20000);
        countingSort(array);
        SortTestHelper.printArray(array);
    }

    public static void countingSort(int[] array) {
        long startTime = System.nanoTime();

        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }

        int[] bucket = new int[max + 1];
        for (int i : array) {
            bucket[i]++;
        }

        int storedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                array[storedIndex++] = i;
                bucket[i]--;
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("countingSort:" + runTime + "ms");
    }
}
