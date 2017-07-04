package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class BubbleSortTest extends Specification {

    @Shared SortingStrategy bubbleSort = new BubbleSort();

    def "should sort using bubble sort strategy for primitive values"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as int[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as int[]

        when:
        bubbleSort.sort(data);

        then:
        assert data.equals(result)
    }
}
