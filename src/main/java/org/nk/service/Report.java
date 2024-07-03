package org.nk.service;

import java.util.List;

public class Report {
    private NumericCalculation calculation;

    public Report(NumericCalculation calculation) {
        this.calculation = calculation;
    }

    public String getReport(long[] numbers) {
        long max = calculation.getMaxNumber(numbers);
        long min = calculation.getMinNumber(numbers);
        double avg = calculation.getAverageValue(numbers);
        double median = calculation.getMedian(numbers);
        List<Long> increasingSequence = calculation.getIncreasingSequenceOfNumbers(numbers);
        List<Long> decreasingSequence = calculation.getDecreasingSequenceOfNumbers(numbers);

        return new StringBuilder().append("The maximum value is ").append(max)
                .append(System.lineSeparator())
                .append("The minimum value is ").append(min)
                .append(System.lineSeparator())
                .append(String.format("The average value is %.2f", avg))
                .append(System.lineSeparator())
                .append(String.format("The median of numbers is %.2f", median))
                .append(System.lineSeparator())
                .append("The longest increasing sequence of numbers: ")
                .append(increasingSequence.toString().replaceAll("[]\\[]", ""))
                .append(System.lineSeparator())
                .append("The longest decreasing sequence of numbers: ")
                .append(decreasingSequence.toString().replaceAll("[]\\[]", ""))
                .toString();
    }
}
