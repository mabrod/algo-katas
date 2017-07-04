package com.brodma.sort;


/**
 * Heapsort is a sorting algorithm which can be split into two distinct stages.
 *
 * 1. The first stage:
 * is to build a tree-based heap data structure from the supplied input.
 * Conforming to the heap property either requires the structure follow that all parent nodes are greater
 * than or equal to their children (with the highest at the root), or the inverse.
 * Being called a max-heap and min-heap respectively, this step in itself has many different interesting
 * use-cases outside of simply sorting an input. Implementing said heap as an array allows us to reuse
 * the input array for both the heap and resulting output. All bst trees are able to be represented
 * in array form, but as a heap is always weighted on the side of completeness, it can be stored very efficiently.
 *
 * 2. The second stage:
 * is to simply build up the sorted array, with the next element removed from the heap structure
 * (reconstructing the heap after each iteration), until no elements are left.
 * The implementation works in both minimum and maximum forms, with only the second steps direction requiring alteration.
 * Being a comparison-based algorithm it caters for a user supplied comparison operation, determining which of
 * the two subject elements should occur first in the output. However, though the option for in-place sorting, it is not stable,
 * resulting in the possibility of initially ordered equal keys being reordered.
 */
public class HeapSort extends AbstractSort implements ComparableSortingStrategy {

    private static int total;

    @Override
    public void sort(Comparable[] arr) {

        total = arr.length - 1;

        // 1. create heap structure from an input. Calling the heapify method on the first half of the input array guarantees
        // (by recursion) to build up the heap data structure and fulfill the heap property
        for (int i = total / 2; i >= 0; i--)
            heapify(arr, i);

        // 2. Once the step 1 has completed we loop through each item in the heap, swapping the first and last heap elements,
        // reducing and reconstructing the structure after each iteration.
        for (int i = total; i > 0; i--) {
            swap(arr, 0, i);
            total--;
            heapify(arr, 0);
        }
    }

    private void heapify(Comparable[] arr, int i) {
        int lft = i * 2;
        int rgt = lft + 1;
        int grt = i;

        if (lft <= total && arr[lft].compareTo(arr[grt]) > 0) grt = lft;
        if (rgt <= total && arr[rgt].compareTo(arr[grt]) > 0) grt = rgt;
        if (grt != i) {
            swap(arr, i, grt);
            heapify(arr, grt);
        }
    }
}
