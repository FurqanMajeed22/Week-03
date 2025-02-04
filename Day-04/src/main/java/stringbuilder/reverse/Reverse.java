package stringbuilder.reverse;

import java.util.Scanner;

public class Reverse {
    public  static  String reverse(String s){
        StringBuilder sb=new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x=sc.next();
        System.out.println(reverse(x));

    }
}
