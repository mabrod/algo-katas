package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class SelectionSortTest extends Specification {

    @Shared SelectionSort selectionSort = new SelectionSort();

    def "should sort using selection sort strategy for Comparable objects"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as Integer[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as Integer[]

        when:
        selectionSort.sort(data);

        then:
        data == result
    }

    def "should sort using selection sort strategy for primitive values"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as int[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as int[]

        when:
        selectionSort.sort(data);

        then:
        data.equals(result)
    }
}
