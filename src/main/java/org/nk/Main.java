package org.nk;

import org.nk.service.NumericCalculation;
import org.nk.service.Report;
import org.nk.utils.FileReaderUtils;

public class Main {

    private static final String DEFAULT_FILE = "10m.txt.bz2";

    public static void main(String[] args) {
        FileReaderUtils readerUtils = new FileReaderUtils();
        String data;
        if (args.length > 0) {
            data = readerUtils.readCompressedFileFromExternalSource(args[0]);
        } else {
            data = readerUtils.readCompressedFileFromResource(DEFAULT_FILE);
        }
        long[] numbers = readerUtils.parseDataToNumbers(data);
        NumericCalculation calculation = new NumericCalculation();
        Report report = new Report(calculation);
        System.out.println(report.getReport(numbers));
    }
}
