package inputstreamreader.reader1;

import java.io.*;

public class filereader{
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change this to your file's path
        String charset = "UTF-8"; // Specify the file encoding

        try (
                FileInputStream fis = new FileInputStream(filePath); // Read binary data
                InputStreamReader isr = new InputStreamReader(fis, charset); // Convert bytes to characters
                BufferedReader br = new BufferedReader(isr) // Efficient reading
        ) {
            String line;
            while ((line = br.readLine()) != null) { // Read each line
                System.out.println(line); // Print to console
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filePath);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error: Unsupported encoding - " + charset);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
