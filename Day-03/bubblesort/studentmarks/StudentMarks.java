package bubblesort.studentmarks;
import java.util.Scanner;
public class StudentMarks {
    public  static  void bubblesort(int []arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of Students");
        int n=sc.nextInt();
        int []marks=new int[n];
        for(int i=0;i<n;i++){
            marks[i]=sc.nextInt();
        }
        //Marks before sorting
        System.out.println("Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();
        //sort marks using bubble sort
        bubblesort(marks);
        System.out.println("After Sorting");
        for(int i=0;i<n;i++){
            System.out.print(marks[i]+" ");
        }


    }
}
