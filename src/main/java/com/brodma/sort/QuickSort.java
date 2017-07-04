package com.brodma.sort;


/**
 * Sort algorithms are ordering the elements of an array according to a predefined order.
 * Quicksort is a divide and conquer algorithm.
 * In a divide and conquer sorting algorithm their the original data is separated into two parts (divide) which are individually
 * sorted (conquered) and then combined.

 * 1.2. Description of the algorithm

 * If the array contains only one element or zero elements then the array is sorted.

 * If the array contains more then one element then:

 * Select an element from the array. This element is called the "pivot element". For example select the element
 * in the middle of the array.

 * All elements which are smaller then the pivot element are placed in one array and all elements which are larger
 * are placed in another array.

 * Sort both arrays by recursively applying Quicksort to them.

 * Combine the arrays

 * Quicksort can be implemented to sort "in-place". This means that the sorting takes place in the array and that
 * no additional array need to be created.
 *
 * Average peformance : O(n log n)
 */

public class QuickSort extends AbstractSort implements SortingStrategy {

    private int[] numbers;
    private int number;

    @Override
    public void sort(int[] values) {

        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                swap(numbers,i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

}
