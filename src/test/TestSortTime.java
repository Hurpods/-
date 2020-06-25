package test;

import N.BucketSort;
import N.CountingSort;
import N.RadixSort;
import NlogN.HeapSort;
import NlogN.MergeSort;
import NlogN.QuickSort;
import NlogN.ShellSort;
import SqureOfN.BubbleSort;
import SqureOfN.InsertSort;
import SqureOfN.SelectionSort;

public class TestSortTime {
    public static void main(String[] args) {
        int[] array;
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        BubbleSort.bubbleSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        InsertSort.insertSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        SelectionSort.selectionSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        ShellSort.shellSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        HeapSort.heapSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        MergeSort.mergeSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        QuickSort.quickSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        CountingSort.countingSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        //RadixSort.radixSort(array);
        array = SortTestHelper.generateRandomArray(30000, 0, 20000000);
        BucketSort.bucketSort(array);
    }
}
