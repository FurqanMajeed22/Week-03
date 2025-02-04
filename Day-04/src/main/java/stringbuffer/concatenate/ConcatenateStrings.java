package stringbuffer.concatenate;

public class ConcatenateStrings {
    public  static  String concatenate(String[]arr){
        StringBuffer sb=new StringBuffer();
        int i=0;
        while (i< arr.length) {
            String x=arr[i];
            sb.append(x);
            i++;
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String []arr={"Furqan","Anubhav","Deepansh","Mayank"};
        System.out.println(concatenate(arr));


    }




}
