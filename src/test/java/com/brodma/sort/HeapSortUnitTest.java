package com.brodma.sort;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class HeapSortUnitTest {

    private ComparableSortingStrategy sut;

    @Before
    public void setUp() {
        sut = new HeapSort();
    }

    @Test
    public void shouldSortBasedOnHeapSort() {
        Integer [] input = {14, 2, 4, 11, 7, 13, 1};
        Integer [] expected = {1,2,4,7,11,13,14};
        sut.sort(input);
        assertThat(input).as("%s not sorted", Arrays.toString(input)).containsExactly(expected);
    }
}