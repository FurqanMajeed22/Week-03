package filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) {
        int count =0;
        String givenword="Furqan";
        String filepath="sample.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            while((line=br.readLine())!=null){
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(givenword)) {
                        count++;
                    }
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
