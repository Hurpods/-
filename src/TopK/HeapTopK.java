package TopK;

import test.SortTestHelper;

import java.util.PriorityQueue;

public class HeapTopK {
    static PriorityQueue<Integer> queue;

    public static void topOrMinK(int[] array, int k, int topOrMin) {
        if (k == 0 || array.length == 0) {
            return;
        }

        if (k > array.length) {
            return;
        }

        if (topOrMin == 1) {
            queue = new PriorityQueue<>();
            for (int num : array) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else if (num > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        } else {
            queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num : array) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortTestHelper.generateRandomArray(10000000, 0, 90000000);
        topOrMinK(array, 3, 1);
        System.out.println(queue);
        topOrMinK(array, 3, 0);
        System.out.println(queue);
    }
}
