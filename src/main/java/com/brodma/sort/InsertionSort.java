package com.brodma.sort;

/**
 * Quadratic O(n squared)
 */
public class InsertionSort extends AbstractSort implements SortingStrategy, ComparableSortingStrategy {

    @Override
    public void sort(int[] data) {

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && key < data[j]) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    @Override
    public void sort(Comparable[] arr) {

        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
