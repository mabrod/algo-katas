package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class MergeSortTest extends Specification {

    @Shared  MergeSort mergeSort = new MergeSort();

    def "should sort using merge sort strategy for primitive values"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as int[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as int[]

        when:
        mergeSort.sort(data);

        then:
        assert data.equals(result)
    }

    def "should sort using merge sort strategy for Comparable objects"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as Integer[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as Integer[]

        when:
        mergeSort.sort(data);

        then:
        assert data == result
    }
}
