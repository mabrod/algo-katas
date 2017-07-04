package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class QuickSortTest extends Specification {

    @Shared  SortingStrategy quickSort = new QuickSort();

    def "should sort using quick sort strategy for primitive values"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as int[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as int[]

        when:
        quickSort.sort(data);

        then:
        assert data.equals(result)
    }
}
