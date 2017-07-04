package com.brodma.sort.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Shuffle {

    private static Random random = new Random();

    public static void main(String[] args) {
        int [] input = IntStream.rangeClosed(1,5000).toArray();
        Shuffle.shuffle(input);
        System.out.println(raffle(input, 5));
    }

    public static Set<Integer> raffle(int a [], int limit) {
        Set<Integer> picked = new HashSet<>();
        int pickedCounter = 0;
        while (pickedCounter < limit) {
            int j = random.nextInt(a.length - 1) + 1;
            if (picked.add(j)) {
                pickedCounter++;
            }
        }
        return picked;
    }

    public static int [] shuffle(int a []) {
        for (int i = 0; i < a.length; i++) {
            int j = random.nextInt(a.length - 1) + 1;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        return a;
    }
}
