package com.brodma.sort.benchmarks;

import com.brodma.sort.ComparableSortingStrategy;
import com.brodma.sort.HeapSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HeapSortBenchmark extends SortsBenchmark {

    private ComparableSortingStrategy sortingStrategy;

    @Setup
    public void setup(BenchmarkParams params) {
        sortingStrategy = new HeapSort();
    }

    @TearDown
    public void cleanUp() {
        sortingStrategy = null;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkHeapSort(Params params) {
        sortingStrategy.sort(params.input);
    }

    @State(Scope.Benchmark)
    public static class Params {
        @Param({"1000", "10000"})
        public int inputSize;
        public Integer []  input;
        public Random random = new Random();

        @Setup
        public void doSetup() {
            input = random.ints(inputSize, 0, inputSize).boxed().toArray(Integer[]::new);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(HeapSortBenchmark.class.getSimpleName()).build();
        new Runner(opt).run();
    }
}
