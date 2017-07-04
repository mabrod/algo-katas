## CI Build
[![Build Status](https://travis-ci.org/mabrod/sort-katas.svg?branch=master)](https://travis-ci.org/mabrod/sort-katas)
I use Travis CI to run CI build pipeline: https://travis-ci.org/

## Learning Sorting algorithms

The code samples show how to implement some sorting algorithms. Most of the implementations are based on the ideas from 
Robert Sedgewick book "Algorithms in Java 3th Edition".
I use JMH benchmark framework to measure performance of each sorting algorithm: http://openjdk.java.net/projects/code-tools/jmh/


## Installation

The code is build with Gradle. Wrapper properties file to start a build with specific Gradle version is provided.

## Usage

Every sorting benchmark class has its own main entry point so you can run it separately or in bulk with jmh gradle plugin.
You can run it from IDE (tested with IntelliJ 2017.1.4) or from command line with: ./gradlew jmh
The JMH benchmarks results are stored in JSON format in build directory under reports/jmh subdirectory.

## Tests

Each sorting algorithm is covered by JUnit 4 and Spock tests.