package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class HeapSortTest extends Specification {

    @Shared ComparableSortingStrategy heapSort = new HeapSort();

    def "should sort using heap sort strategy Comparable objects"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as Integer[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as Integer[]

        when:
        heapSort.sort(data);

        then:
        assert data == result
    }
}
