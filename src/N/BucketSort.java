package N;

import test.SortTestHelper;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000, 0, 20000);
        bucketSort(array);
        SortTestHelper.printArray(array);
    }

    public static void bucketSort(int[] array) {
        long startTime = System.nanoTime();

        if (array.length == 0) {
            return;
        }

        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / 5) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int item : array) {
            int index = (int) Math.floor((item - minValue) / 5);
            buckets[index] = arrayAppend(buckets[index], item);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            insertSort(bucket);
            for (int value : bucket) {
                array[arrIndex++] = value;
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("bucketSort:" + runTime + "ms");
    }

    private static int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    public static void insertSort(int[] array) {
        int j;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }
}
