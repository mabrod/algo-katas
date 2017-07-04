package com.brodma.sort;


/**
 * Insertion sort is inefficient because it moves items only one position at a time
 * Shell sort build on insertion sort to move item by n number of positions
 * Th key is to come up with effective number by which to move items
 * Powers of two: 2,4,8, 16 does not work
 * Shell proposition : powers of two minus 1 -> 1, 3, 7 works quite well but not optimal
 * Knuth proposed : 3x + 1 sequence works well
 * Scientists are stil looking into it to find the best number to move the items at once
 *
 * the performance is still not determed by scientists so no big 0 notation for Shell sort !!!
 */
public class ShellSort extends AbstractSort implements ComparableSortingStrategy{

    @Override
    public void sort(Comparable[] arr) {

        int size = arr.length;
        int h = 1;
        // 1. get increment sequence (based Knuth 3x + 1)
        while( h < (size/ 3)) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121...
        }

        while (h >= 1) {
            // 2. use Insertion sort algorithm below
            for (int i = h; i < size; i++) {
                for (int j = i; j >=h && less(arr[j], arr[j - h]); j-= h) {
                   swap(arr, j, j - h);
                }
            }
            // 3. move to the next increment
            h = h / 3;
        }
    }
}
