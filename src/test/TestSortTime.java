package test;

import NlogN.ShellSort;
import SqureOfN.BubbleSort;
import SqureOfN.InsertSort;
import SqureOfN.SelectionSort;

public class TestSortTime {
    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(100, 0, 200);
        BubbleSort.bubbleSort(array);
        array = SortTestHelper.generateRandomArray(100, 0, 200);
        InsertSort.insertSort(array);
        array = SortTestHelper.generateRandomArray(100, 0, 200);
        SelectionSort.selectionSort(array);
        array = SortTestHelper.generateRandomArray(100, 0, 200);
        ShellSort.shellSort(array);
    }
}
