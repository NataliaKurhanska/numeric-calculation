package org.nk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

public class FileReaderUtils {

    public String readCompressedFileFromResource(String file) {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
                CompressorInputStream compressorInputStream = new CompressorStreamFactory()
                        .createCompressorInputStream(bufferedInputStream);
                BufferedReader reader = new BufferedReader(new InputStreamReader(compressorInputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (CompressorException | IOException e) {
            throw new RuntimeException("Can't read data from the file: " + e);
        }
    }

    public String readCompressedFileFromExternalSource(String externalFile) {
        try (InputStream inputStream = new FileInputStream(externalFile);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                CompressorInputStream compressorInputStream = new CompressorStreamFactory()
                        .createCompressorInputStream(bufferedInputStream);
                BufferedReader reader = new BufferedReader(new InputStreamReader(compressorInputStream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (CompressorException | IOException e) {
            throw new RuntimeException("Can't read data from the file: " + e);
        }
    }

    public long[] parseDataToNumbers(String data) {
        if (data.isEmpty()) {
            throw new RuntimeException("Can't parse an empty data");
        }
        return Arrays.stream(data.split(System.lineSeparator())).mapToLong(Long::parseLong).toArray();
    }
}
