package SqureOfN;

import test.SortTestHelper;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        insertSort(array);
        SortTestHelper.printArray(array);
    }

    //插入排序由N-1趟排序完成，每次遍历时候比较当前元素与其之前的各个元素大小，如果前方存在比当前元素大的元素，则将其插入到第一个小于当前元素之后
    public static void insertSort(int[] array) {
        long startTime = System.nanoTime();

        int j;
        //外部循环，从第一个元素开始，逐步遍历到总长度
        for (int i = 0; i < array.length; i++) {
            //获取当前遍历头的元素
            int temp = array[i];
            //从当前遍历头向前进行遍历，如果前方存在比当前遍历元素大的元素，则将其赋值到当前元素位置
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            //内循环结束后j将停止到数组有序部分的最后一位，此时再将前面获取的遍历头元素赋值到此，就完成了一轮内循环
            array[j] = temp;
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("insertSort:" + runTime + "ms");
    }
}
