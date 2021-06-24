/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.parallelhw11;

/**
 *
 * @author aditi
 */
import static com.aditicompany.parallelhw11.Q5a.partition;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import static pmbauer.parallel.Quicksort.partition;

/**
 * Root task to encapsulate:
 * <ul>
 * <li>array to sort</li>
 * <li>sorting threshold : computed in the constructor; sub-tasks smaller than this are serially sorted</li>
 * <li>latch : synchronization object that signals when the work is complete</li>
 * <li>sub-task spawning</li>
 * </ul>
 */
public class LatchQuicksortTask implements Runnable {

    /**
     * Defines bounded region (sub-array) of array to sort.
     */
    private static class QuicksortSubTask implements Runnable {
        private final int left;
        private final int right;
        private final LatchQuicksortTask root;

        QuicksortSubTask(LatchQuicksortTask task) {
            this(task, 0, task.getTaskSize() - 1);
        }

        QuicksortSubTask(LatchQuicksortTask rootTask, int left, int right) {
            this.left = left;
            this.right = right;
            this.root = rootTask;
        }

        @Override
        public void run() {
            int pivotIndex = root.partitionOrSort(left, right);

            if (pivotIndex >= 0) {
                if (left < pivotIndex)
                    root.execute(new QuicksortSubTask(root, left, pivotIndex));
                if (pivotIndex + 1 < right)
                    root.execute(new QuicksortSubTask(root, pivotIndex + 1, right));
            }
        }

    }

    private final int serialThreshold;
    private final ExecutorService pool;
    private final CountDownLatch latch;
    private final int[] a;

    public LatchQuicksortTask(int[] a, ExecutorService threadPool) {
        serialThreshold = Math.max(a.length / (Runtime.getRuntime().availableProcessors() * 4), 4096);
        pool = threadPool;
        latch = new CountDownLatch(a.length);
        this.a = a;
        System.out.println("serialThreshold: "+serialThreshold);
    }

    public final void waitUntilSorted() throws InterruptedException {
        latch.await();
    }

    final int getTaskSize() {
        return a.length;
    }

    @Override
    public void run() {
        execute(new QuicksortSubTask(this));
    }

    private void execute(Runnable runnable) {
        pool.execute(runnable);
    }

    /*
     * If the array sub-section [left,right] is small enough, fully sorts the sub-section and returns -1.
     * Otherwise, it partitions the subsection and returns an index within [left,right] such that
     * all values at indices <= returned index are less than values at indices > returned index.
     */
    private int partitionOrSort(int left, int right) {
        int pivotIndex = -1;
        int sortedCount;

        if (serialThresholdMet(left, right)) {
            Arrays.sort(a, left, right + 1);
            sortedCount = right - left + 1;
        } else {
            pivotIndex = partition(a, left, right);
            sortedCount = countSortedBoundaryValues(left, right, pivotIndex);
        }

        latch.countDown(sortedCount);

        return pivotIndex;
    }

    /*
     * When left == pivotIndex, then a[left] is its sorted position.
     * When right == pivotIndex + 1, then a[right] is in its sorted position.
     *
     * As long as serialThreshold is guaranteed > 2, these two conditions are mutually exclusive.
     * Therefore, we can gain a minor efficiency and avoid an extra branch for each case.
     */
    private int countSortedBoundaryValues(int left, int right, int pivotIndex) {
        return (left == pivotIndex || right == pivotIndex + 1) ? 1 : 0;
    }

    private boolean serialThresholdMet(int left, int right) {
       // System.out.print(" right - left < serialThreshold : " + (right - left < serialThreshold));
        
        return right - left < serialThreshold;
    }
    
    
    public static void main(String[] args) {
        int arr[] = new int[100000];// {91, 37, 42, 38, 3, 9, 62, 10, 21, 8, 34, 19, 6, 18, 21, 25};

        Random rd = new Random(); // creating Random object

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
            // System.out.println(arr[i]); // printing each array element
        }
        //int n = arr.length;
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //threadPool.submit();
        LatchQuicksortTask obj = new LatchQuicksortTask(arr,threadPool);
        long start = System.nanoTime();
        threadPool.submit(new QuicksortSubTask(obj));
        threadPool.submit(new QuicksortSubTask(obj));
        threadPool.submit(new QuicksortSubTask(obj));
        long finish = System.nanoTime();
        long timeElapsed1 = finish - start;
        System.out.println("time taken - " + timeElapsed1);

        threadPool.shutdown();
        
         System.out.println(arr[0]+ " "+ arr[99999]);
        
    }
}
