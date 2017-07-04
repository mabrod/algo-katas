package com.brodma.sort;

public class AbstractSort {

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void swap(Comparable [] a, int i, int j) {
        Comparable exchange = a[i];
        a[i] = a[j];
        a[j] = exchange;
    }

    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
