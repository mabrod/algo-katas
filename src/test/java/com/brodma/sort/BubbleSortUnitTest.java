package com.brodma.sort;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortUnitTest {

    private SortingStrategy sut;

    @Before
    public void setUp() {
        sut = new BubbleSort();
    }

    @Test
    public void shouldSortBasedOnBubbleSort() {
        int [] input = {14,2,4,11,7,13,1,1};
        int [] expected = {1,1,2,4,7,11,13,14};
        sut.sort(input);
        assertThat(input).as("%s not sorted", Arrays.toString(input)).containsExactly(expected);
    }
}