package selectionsort.sortexamscores;

import java.util.Scanner;

public class ExamScores {
    public  static  void SelectionSort(int []Scores){
        int n=Scores.length;
        for(int i=0;i<n;i++){
            int minidex=i;
            for(int j=i+1;j<n;j++){
                if(Scores[j]<Scores[minidex]){
                    minidex=j;

                }
            }
            int temp=Scores[minidex];
            Scores[minidex]=Scores[i];
            Scores[i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number Of Students");
        int n=sc.nextInt();
        int []Scores=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Score of Student "+ i);
            Scores[i]=sc.nextInt();
        }
        System.out.println("Prices of Products Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(Scores[i]+" ");
        }
        System.out.println();
        SelectionSort(Scores);
        for(int i=0;i<n;i++){
            System.out.print(Scores[i]+" ");
        }


    }
}
