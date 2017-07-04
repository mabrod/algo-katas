package com.brodma.sort;

/**
 * Quadratic O(n squared)
 */
public class BubbleSort extends AbstractSort implements SortingStrategy {

    @Override
    public void sort(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i++) {
            for(int j = 1; j < len; j++) {
                if(data[j - 1] > data[j]) {
                    swap(data, j, j -1);
                }
            }
        }
    }
}
