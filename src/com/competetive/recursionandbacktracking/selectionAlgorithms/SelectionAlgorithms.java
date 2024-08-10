package com.competetive.recursionandbacktracking.selectionAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class SelectionAlgorithms {
    /**
     * we may have intuition if we use sorting.
     * if we have the sorted data structure array then we can find k-th order statistics
     * with index k-1
     * sorting has O(NlogN) running time complexity (LinearRithmic Running Time Complexity.)
     * NOTE: Selection Algorithms are in place which means that they do not need additional memory
     *
     */

    /**
     * Online selection algorithms
     * for example when we download data we want to find the k-th order
     * statistics(minimum, maximum, or median) on the fly.
     *
     * PROBLEM : We do not know the values in advance
     * we can not find the best solution but we may have an educated guess we may find the item
     * with high probability.
     * This is so-called secretary problem.
     */

    /**
     * QUICKSELECT
     * It is a selection algorithm designed by tony Hoare
     * quickselect is a selection algorithm - it is able to find the kth smallest largest item in an unordered array.
     * In place does not need additional memory
     *
     * THE ALGORITHM
     * 1. Choose so called pivot item at random
     * 2. Partition the array (based on the value of the pivot)
     * 3. Instead of recursion into both sides, we take just one side.
     *      THE PARTITION PHASE:
     *                           Pivot
     *                 [1   -2  | 5  | 8   7   6]
     *          Choose the pivot value at random: we generate a random number
     *          in the range[first_index, last_index]
     *          Re-arrange the array in a way that all elements less than the pivot are on the left side of pivot
     *          and other on the right.
     *
     *              ~ partition returns with the final position (index)
     *                  of the pivot element.
     *                           Pivot
     *                 [1   -2  | 5  | 8   7   6]
     *
     *          We are done, we return the index of the pivot! Of course in the course of the algorithm,
     *          we may have to make several partition procedure.
     *
     *          Main idea behind quickselect: we just need one half of the array.
     *
     *          LEFT SIDE: left subarray:  if we want to find the small items
     *                     For example: third-smallest value etc.
     *          RIGHT SIDE: right subarray: we want the large items
     *                     For example: second-largest value etc.
     *      THE SELECTION PHASE:
     *          After partitioning there may be 3 cases;
     *          1. k == pivot
     *              It means we have found the k-th smallest (largest) item we are after because
     *              this is how partitioning works: there are exactly k-1 items that are smaller
     *              than the pivot (in this case pivot == k)
     *          2. k < pivot
     *              The k-th smallest item is on the left side of the pivot, thats why we can
     *              discard the other subarray(unlike quicksort)
     *          3. k > pivot
     *              The k-th smallest item is on the right side of the pivot
     *
     */
    static class QuickSelect {
        private int[] nums;
        public QuickSelect(int[] nums) {
            this.nums = nums;
        }
        public int select(int k) {
            return quickSelect(0, nums.length - 1, k - 1);
        }
        //PARTITION PHASE
        private int partition(int firstIndex, int lastIndex) {
            int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
            swap(pivot, lastIndex);
            for(int i = firstIndex; i < lastIndex; ++i) {
                if(nums[i] < nums[lastIndex]) { // if we need to find kth largest the make this > than.
                    swap(i, firstIndex);
                    firstIndex++;
                }
            }
            swap(lastIndex, firstIndex);
            //Index of the pivot
            return firstIndex;
        }
        private void swap(int pivot, int lastIndex) {
            int temp = nums[pivot];
            nums[pivot] = nums[lastIndex];
            nums[lastIndex] = temp;
        }
        //SELECTION PHASE
        private int quickSelect(int firstIndex, int lastIndex, int k) {
            int pivotIndex = partition(firstIndex, lastIndex);
            if(pivotIndex < k) {
                // we can discard the items in left subarray
                return quickSelect(pivotIndex + 1, lastIndex, k);
            } else if (pivotIndex > k) {
                // we can discard the right sub-array so we have to consider the items on the left.
                return quickSelect(firstIndex, pivotIndex - 1, k);
            }
            return nums[pivotIndex];
        }
        // Sort an array with QuickSelect

    }
    static class Exercise {

        private int[] nums;

        public Exercise(int[] nums) {
            this.nums = nums;
        }

        public int[] sort() {

            int[] sorted = new int[nums.length];
            int lastIndex = nums.length - 1;
            int k = 0;
            for(int i = lastIndex; i >= 0; i--) {
                sorted[i] = quickSelect(0, nums.length - 1, i);
            }
            // your algorithm here
//                System.out.println(Arrays.toString(sorted));
            return sorted;
        }

        // SO PARTITION PHASE
        private int partition(int firstIndex, int lastIndex) {

            // index of the random pivot [firstIndex, lastIndex]
            int pivotIndex = new Random().nextInt(lastIndex-firstIndex+1) + firstIndex;

            swap(pivotIndex, lastIndex);

            for(int i=firstIndex;i<lastIndex;++i) {
                if(nums[i]>nums[lastIndex]) {
                    swap(i, firstIndex);
                    firstIndex++;
                }
            }

            swap(lastIndex, firstIndex);

            // this is the index of the pivot
            return firstIndex;
        }

        private void swap(int pivot, int lastIndex) {
            int temp = nums[pivot];
            nums[pivot] = nums[lastIndex];
            nums[lastIndex] = temp;
        }

        // THIS IS THE SELECTION PHASE
        private int quickSelect(int firstIndex, int lastIndex, int k) {

            int pivotIndex = partition(firstIndex, lastIndex);

            if(pivotIndex<k) {
                // we can discard the left sub-array so we have to
                // consider the items on the right
                return quickSelect(pivotIndex+1, lastIndex, k);
            } else if(pivotIndex>k) {
                // we can discard the right sub-array so we have to
                // consider the items on the left
                return quickSelect(firstIndex, pivotIndex-1, k);
            }

            return nums[pivotIndex];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -5, 10, 55, 2, 3, -7, 7, 11, 100};
        QuickSelect quickSelect = new QuickSelect(nums);
        System.out.println(quickSelect.select(5));
        Exercise exercise = new Exercise(nums);
        System.out.println(Arrays.toString(exercise.sort()));
    }
}
