package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFiles {
    public static void main(String[] args) {
        String filepath= "src/sample.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line= br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
