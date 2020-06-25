package SqureOfN;


import test.SortTestHelper;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        int[] array2 = SortTestHelper.generateRandomArray(100, 0, 200);
        CockTailSort(array);
        bubbleSort(array2);
        SortTestHelper.printArray(array);
        SortTestHelper.printArray(array2);
    }

    //冒泡排序是遍历数组时，比较两两相邻的大小，如果左边比右边大，则交换其位置，每一轮外循环完成，最右侧都将是最大元素/最左侧是最小元素，称为有序部分
    //基本带flag的优化法，通过此方法避免排序提早完成而仍然进行多次后续对比
    public static void bubbleSort(int[] array) {
        long startTime = System.nanoTime();

        //从下标为1开始遍历，逐步遍历到总长度
        for (int i = 1; i < array.length; i++) {
            //设置flag，当进行交换操作，flag设为false，每当内嵌循环完成判断flag是否为true，如果为true，即当次循环未发生交换，则认为已排序完成，跳出循环
            boolean flag = true;
            //内嵌循环，从0位置开始，逐步遍历到总长度减去已排序个数次数，因为每一个外部循环完成，都是将最大的数向最后冒泡到底，其尾部认为是有序的，故不需要二次遍历
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("bubbleSort:" + runTime + "ms");
    }

    //鸡尾酒排序，是冒泡排序的变种，与冒泡排序不同点在于每一趟外循环中内嵌两个循环，一次从数组头将最大值移动到尾，一次从数组尾将最小值移动到头，减少移动次数
    private static void CockTailSort(int[] array) {
        long startTime = System.nanoTime();

        //由于每一次外循环都将从数组头和数组尾都进行移动数据，因此只需要进行数组长度一半的遍历次数就可以完成排序
        for (int i = 0; i < array.length / 2; i++) {
            boolean flag = true;
            //由于排序从两头同时进行，因此内循环从数组头移动时应当从第i个(已有序化的部分)开始
            //总循环次数为数组长度减去有序部分再减去1，因为从数组尾循环会执行到这个位置
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                }
            }

            //内循环从数组尾移动的时候应当从数组长减去已有序部分再减去1，即从数组尾无序部分开始
            //当j大于i，即当前遍历下表还在数组头无序部分时，继续执行
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("CockTailSort:" + runTime + "ms");
    }

    private static void swap(int[]a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
