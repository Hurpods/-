package N;

import test.SortTestHelper;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 0, 20000);
        radixSort(array);
        SortTestHelper.printArray(array);
    }

    public static void radixSort(int[] array) {
        long startTime = System.nanoTime();

        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        int maxDigit = 0;
        if (max == 0) {
            maxDigit = 1;
        }
        for (long temp = max; temp != 0; temp /= 10) {
            maxDigit++;
        }

        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];
            for (int item : array) {
                int bucket = ((item % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], item);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    array[pos++] = value;
                }
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("radixSort:" + runTime + "ms");
    }

    private static int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }
}
