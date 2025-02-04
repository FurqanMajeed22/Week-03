package challengeproblem;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceCheck{
    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer();
        compareFileReaders("sample.txt");
    }
    // Part 1: Compare StringBuilder and StringBuffer Performance
    private static void compareStringBuilderAndStringBuffer() {
        int iterations = 1000000;
        String text = "hello";
        // Measure time taken by StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");
        // Measure time taken by StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime)  + " ns");
    }

    // Part 2: Compare FileReader and InputStreamReader for Word Count
    private static void compareFileReaders(String filePath) {
        // Using FileReader
        long startTime = System.nanoTime();
        int wordCount1 = countWordsUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("FileReader Word Count: " + wordCount1 + ", Time: " + (endTime - startTime) + " ns");

        // Using InputStreamReader
        startTime = System.nanoTime();
        int wordCount2 = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Word Count: " + wordCount2 + ", Time: " + (endTime - startTime) + " ns");
    }

    // Count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words in the line
            }
        } catch (IOException e) {
            System.err.println("FileReader Error: " + e.getMessage());
        }
        return wordCount;
    }

    // Count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words in the line
            }
        } catch (IOException e) {
            System.err.println("InputStreamReader Error: " + e.getMessage());
        }
        return wordCount;
    }
}
