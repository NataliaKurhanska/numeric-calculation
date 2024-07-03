package org.nk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public class NumericCalculation {
    public long getMaxNumber(long[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow(() ->
                new NoSuchElementException("Can't find a maximum number"));
    }

    public long getMinNumber(long[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow(() ->
                new NoSuchElementException("Can't find a minimum number"));
    }

    public double getAverageValue(long[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow(() ->
                new NoSuchElementException("Can't get average value of numbers"));
    }

    public double getMedian(long[] numbers) {
        OptionalDouble mediana = numbers.length % 2 == 0
                ? Arrays.stream(numbers).sorted().skip(numbers.length / 2 - 1).limit(2).average()
                : Arrays.stream(numbers).sorted().skip(numbers.length / 2).asDoubleStream().findFirst();
        return mediana.orElseThrow(() ->
                new NoSuchElementException("Can't get mediana of numbers"));
    }

    public List<Long> getIncreasingSequenceOfNumbers(long[] numbers) {
        long maxSequenceLength = 0;
        List<Long> increasingNumSequence = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            List<Long> potentionalSequence = new ArrayList<>();
            int count = 1;
            int j = i;
            if (numbers[i + 1] > numbers[i]) {
                potentionalSequence.add(numbers[i]);
                while (j < numbers.length - 1 && numbers[j + 1] > numbers[j]) {
                    count++;
                    j++;
                    potentionalSequence.add(numbers[j]);
                }
            }
            if (count > maxSequenceLength) {
                maxSequenceLength = count;
                increasingNumSequence = new ArrayList<>(potentionalSequence);
                potentionalSequence.clear();
            }
            i = j;
        }
        return increasingNumSequence;
    }

    public List<Long> getDecreasingSequenceOfNumbers(long[] numbers) {
        long maxSequenceLength = 0;
        List<Long> decreasingNumSequence = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            List<Long> potentionalSequence = new ArrayList<>();
            int count = 1;
            int j = i;
            if (numbers[i + 1] < numbers[i]) {
                potentionalSequence.add(numbers[i]);
                while (j < numbers.length - 1 && numbers[j + 1] < numbers[j]) {
                    count++;
                    j++;
                    potentionalSequence.add(numbers[j]);
                }
            }
            if (count > maxSequenceLength) {
                maxSequenceLength = count;
                decreasingNumSequence = new ArrayList<>(potentionalSequence);
                potentionalSequence.clear();
            }
            i = j;
        }
        return decreasingNumSequence;
    }
}
