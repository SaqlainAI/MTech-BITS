package com.dsa.assignment.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dsa.assignment.utils.Constants.*;

public class DataReader {

    private DataReader() {}

    private static List<Integer> readFromTextFile(String fileName) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            List<String> data = lines.collect(Collectors.toList());
            return data.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
    }

   private static List<Integer> readFromCSVFile(String fileName) throws IOException{
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            if(line != null) {
                String[] values = line.split(COMMA_DELIMITER);
                data = Arrays.asList(values);
            }
            return data.stream().map(Integer::parseInt).collect(Collectors.toList());
        }
   }

   public static List<Integer> readDataFromFile(String fileName) throws IOException {
        String fileType = getFileType(fileName);
        if(fileType.equalsIgnoreCase(CSV)) return readFromCSVFile(fileName);
        if(fileType.equalsIgnoreCase(TEXT)) return readFromTextFile(fileName);
        System.out.println("Unsupported file type: " + fileType);
        return Collections.emptyList();
   }

    private static String getFileType(String fileName)  {
        File file = new File(fileName);
        String fileExtension = file.getName().toLowerCase();
        boolean isTextFile = fileExtension.endsWith(".txt");
        boolean isCSV = isTextFile ? false : fileExtension.endsWith(".csv");
        return isCSV ? CSV : isTextFile ? TEXT : fileExtension;
    }

}
