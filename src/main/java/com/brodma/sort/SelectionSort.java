package com.brodma.sort;

/**
 * Quadratic O(n squared)
 * Selection sort will iterate over all the items to find a minimum index value and swap values to put the next minimum
 * into its position
 */
public class SelectionSort extends AbstractSort implements SortingStrategy, ComparableSortingStrategy {

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int j = findMinIndex(data, i);
            swap(data, i, j);
        }
    }

    private int findMinIndex(int[] array, int start) {
        int min = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }

    private int findMinIndex(Comparable [] array, int start) {
        int min = start;
        for (int j = start; j < array.length; j++) {
            if (less(array[j], array[min])) {
                min = j;
            }
        }
        return min;
    }

    @Override
    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = findMinIndex(arr,i);
            swap(arr, i, min);
        }
    }
}
