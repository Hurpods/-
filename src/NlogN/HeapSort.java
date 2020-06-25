package NlogN;

import test.SortTestHelper;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        heapSort(array);
        SortTestHelper.printArray(array);
    }

    //堆排序是利用了二叉堆的结构进行排序，一个二叉堆是完全二叉树，且从根节点向下，每一层的大小依次递减(大根堆)\递增(小根堆)
    //利用大根堆的特性，建造一个大根堆，每次将最大元找出且放在数组尾，即可快速排序
    public static void heapSort(int[] array) {
        long startTime = System.nanoTime();
        //构造大根堆，从第一个非叶子节点处开始进行下滤，由此将无序数组构建为一个大根堆
        for (int i = array.length / 2 - 1; i > 0; i--) {
            percolateDown(array, i, array.length);
        }
        //从末尾元素开始排序，将堆顶元素与末尾元素互换，使末尾元素最大，然后继续下滤调整堆结构，反复遍历到堆顶，即遍历完成
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            percolateDown(array, 0, i);
        }

        long endTime = System.nanoTime();
        float runTime = (endTime - startTime) / 1000000f;
        System.out.println("HeapSort:" + runTime + "ms");
    }

    //因为数组从0开始计算下表，因此左子节点位于父节点i的两倍+1下标处
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    //下滤方法，输入参数为下滤数组，下滤起始位置和终结位置
    private static void percolateDown(int[] array, int i, int j) {
        int child;
        int temp;
        //若当前节点的子节点没有超过下滤终结位置，则开始下滤
        for (temp = array[i]; leftChild(i) < j; i = child) {
            child = leftChild(i);
            //判断是否存在比左子节点大的右子节点，如果存在，则选中右子节点
            if (child != j - 1 && array[child] < array[child + 1]) {
                child++;
            }
            //若选中的子节点比当前节点大，则将当前节点下滤到该子节点所在位置，将该子节点的值赋给当前节点
            if (temp < array[child]) {
                array[i] = array[child];
            } else {
                break;
            }
        }
        //遍历结束后，下滤开始的节点已经下滤到第一个小于其的子节点之前，下滤区间内的最大元素已上浮到下滤起始位置
        array[i] = temp;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
