package com.brodma.sort.benchmarks;

import com.brodma.sort.InsertionSort;
import com.brodma.sort.SortingStrategy;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InsertionSortBenchmark extends SortsBenchmark {

    private SortingStrategy sortingStrategy;

    @Setup
    public void setup(BenchmarkParams params) {
        sortingStrategy = new InsertionSort();
    }

    @TearDown
    public void cleanUp() {
        sortingStrategy = null;
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchmarkInsertionSort(Params params) {
        sortingStrategy.sort(params.input);
    }

    @State(Scope.Benchmark)
    public static class Params {
        @Param({"1000", "10000"})
        public int inputSize;
        public int [] input;
        public Random random = new Random();

        @Setup
        public void doSetup() {
            input = random.ints(inputSize, 0, inputSize).toArray();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(InsertionSort.class.getSimpleName()).build();
        new Runner(opt).run();
    }
}
