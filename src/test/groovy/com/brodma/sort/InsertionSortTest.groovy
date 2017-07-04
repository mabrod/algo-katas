package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class InsertionSortTest extends Specification {

    @Shared InsertionSort insertionSort = new InsertionSort();

    def "should sort using insertion sort strategy for primitive values"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as int[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as int[]

        when:
        insertionSort.sort(data);

        then:
        data.equals(result)
    }

    def "should sort using insertion sort strategy for Comparable objects"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as Integer[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as Integer[]

        when:
        insertionSort.sort(data);

        then:
        data == result
    }
}
