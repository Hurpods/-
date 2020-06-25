package NlogN;

import test.SortTestHelper;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        shellSort(array);
        SortTestHelper.printArray(array);
    }

    //希尔排序是O(NlogN)效率的排序方法，使用分治算法的思想，规定一个间隔值，每次按照间隔取两个数进行对比，并交换位置
    public static void shellSort(int[] array) {
        long startTime = System.nanoTime();

        int j;
        //采用二分的思想，取间隔值为数组长度的一半，当间隔值大于0时则认为其没有完成相邻元素的大小对比，继续二分
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //以间隔值作为下标开始遍历到数组尾
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                //以间隔值下标开始，与向前的元素，每间隔一个间隔值进行对比，当存在大于当前元素的值时，将二者替换
                for (j = i; j > gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("shellSort:" + runTime + "ms");
    }
}
