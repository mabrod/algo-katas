package com.brodma.sort

import spock.lang.Shared
import spock.lang.Specification

class ShellSortTest extends Specification {

    @Shared  ComparableSortingStrategy shellSort = new ShellSort();

    def "should sort using shell sort strategy based on Comparable objects"() {
        given:
        def data = [31, 7, 2, 34, 10, 5, 40, 22] as Integer[]
        def result = [2, 5, 7, 10, 22, 31, 34, 40] as Integer[]

        when:
        shellSort.sort(data);

        then:
        data == result
    }
}
