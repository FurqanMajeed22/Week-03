package stringbuilder.removeduplicate;
import java.util.HashSet;
import java.util.Scanner;

public class Removeduplicates {
    public static String removeduplicates(String x){
        StringBuilder ss=new StringBuilder();
        HashSet<Character>mp=new HashSet<>();
        for(int i=0;i<x.length();i++){
            if(!mp.contains(x.charAt(i))){
                ss.append(x.charAt(i));
            }
            mp.add(x.charAt(i));

        }
        return ss.toString();


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x=sc.next();
        System.out.println(x);
        System.out.println(removeduplicates(x));


    }

}
