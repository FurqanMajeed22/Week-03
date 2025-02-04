package inputstreamreader.reader2;

import java.io.*;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Output file

        try (
                InputStreamReader isr = new InputStreamReader(System.in); // Read from console
                BufferedReader br = new BufferedReader(isr); // Efficient reading
                FileWriter fw = new FileWriter(filePath, true); // Append mode to preserve previous inputs
                BufferedWriter bw = new BufferedWriter(fw) // Efficient writing
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (true) {
                line = br.readLine(); // Read user input
                if ("exit".equalsIgnoreCase(line)) { // Stop condition
                    break;
                }
                bw.write(line); // Write input to file
                bw.newLine(); // Move to the next line
            }

            System.out.println("User input has been saved to " + filePath);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
