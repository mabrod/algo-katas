package com.brodma.sort;


/**
 * During the Mergesort process the object in the collection are divided into two collections. To split a collection,
 * Mergesort will take the middle of the collection and split the collection into its left and its right part.
 * The resulting collections are again recursively sorted via the Mergesort algorithm.
 * Once the sorting process of the two collections is finished, the result of the two collections is combined. T
 * o combine both collections Mergesort start at each collection at the beginning. It pick the object which is smaller
 * and inserts this object into the new collection. For this collection it now selects the next elements and selects
 * the smaller element from both collection.
 * Once all elements from both collections have been inserted in the new collection, Mergesort has successfully sorted the collection.
 * To avoid the creation of too many collections, typically one new collection is created and the left and right side
 * are treated as different collections.


 * 1. Divide the unsorted list into two sublists of about half the size
 * 2. Sort each of the two sublists
 * 3. Merge the two sorted sublists back into one sorted list
 * Big 0 = n log n -> because we have n elements to consider (liner) and log n calls (recursive operations)
 */
public class MergeSort extends AbstractSort implements SortingStrategy, ComparableSortingStrategy {

    private int[] numbers;
    private int[] helper;

    private int number;


    @Override
    public void sort(int[] values) {

        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

    // ============ Comparable part =============================

    private Comparable[] compHelper;

    @Override
    public void sort(Comparable[] arr) {
        compHelper = new Comparable[arr.length];
        sort(arr, compHelper, 0, arr.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] helper, int lo, int hi) {
        //usee recursion
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) /2;
        sort(a, helper, lo, mid); // sort the first half
        sort(a, helper, mid + 1, hi); // sor the second half
        merge(a, helper, lo, mid, hi); // merge two sorted arrays together into final sorted array
    }

    private void merge(Comparable[] a, Comparable[] helper, int lo, int mid, int hi) {

        //1. first copy array to be sorted into helper array
        for (int k = lo; k <= hi; k++) {
            helper[k] = a[k];
        }
        // 2. do the merge
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = helper[j++];
            } else if (j > hi) {
                a[k] = helper[i++];
            } else if(less(helper[j], helper[i])) {
                a[k] = helper[j++];
            } else {
                a[k] = helper[i++];
            }
        }
    }
}
