package SqureOfN;

import test.SortTestHelper;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        selectionSort(array);
        SortTestHelper.printArray(array);
    }

    //选择排序由N-1趟排序完成，每次遍历时从无序部分头部开始向数组尾查找最小的值，当查找到后，将其排放到无序部分第一个元素位置
    public static void selectionSort(int[] array) {
        long startTime = System.nanoTime();

        //从第一个元素开始遍历，总遍历次数为N-1
        for (int i = 0; i < array.length; i++) {
            int min = i;
            //从无序部分第一个元素开始，遍历到数组尾
            for (int j = i + 1; j < array.length; j++) {
                //当存在比当前元素更小的元素时，获取更小元素的下标
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //如果当前最小值下标不等于最初下标，则认为找到了更小的元素，交换两者的位置
            if (min != i) {
                swap(array, i, min);
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("selectionSort:" + runTime + "ms");
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
