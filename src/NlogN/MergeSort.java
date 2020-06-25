package NlogN;

import test.SortTestHelper;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        mergeSort(array);
        SortTestHelper.printArray(array);
    }

    //归并排序采用分治算法的思想，将一个数组分裂成若干个等长数组，再对其中的数两两对比，较小的先放入临时存储数组中，较大的后放入，即可完成排序
    public static void mergeSort(int[] array) {
        long startTime = System.nanoTime();

        int[] temp = new int[array.length];
        //参数为：原始数组，临时存储数组，数组头下标，数组尾下标
        mergeSort(array, temp, 0, array.length - 1);

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("mergeSort:" + runTime + "ms");
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            //获取中位
            int center = (left + right) / 2;
            //递归将分裂后数组继续分裂，直到left<=right，即最终一个数组中只有一个数
            mergeSort(array, temp, left, center);
            mergeSort(array, temp, center + 1, right);
            //合并数组，参数为：原始数组，临时存储数组，左侧起始点，右侧起始点，右侧终点
            merge(array, temp, left, center + 1, right);
        }
    }

    private static void merge(int[] array, int[] temp, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        //主要循环，当数组左右两侧均未遍历完成时，进行遍历
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            //选取数组两侧中较小的一个放入到临时存储数组中
            if (array[leftPos] < array[rightPos]) {
                temp[tempPos++] = array[leftPos++];
            } else {
                temp[tempPos++] = array[rightPos++];
            }
        }

        //跳出主循环后剩余部分必然是有序的，直接添加到临时存储数组中即可
        while (leftPos <= leftEnd) {
            temp[tempPos++] = array[leftPos++];
        }
        while (rightPos <= rightEnd) {
            temp[tempPos++] = array[rightPos++];
        }

        //将排序后的数组放回到原始数组中
        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = temp[rightEnd];
        }
    }
}
