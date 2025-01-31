package quicksort.sortproduct;

import java.util.Scanner;

public class SortProducts {
    public  static  int partition(int []Prices,int start,int end){
        int pivotindex=start;
        int count=0;
        for(int i=start+1;i<=end;i++){
            if(Prices[i]<Prices[pivotindex]){
                count++;
            }
        }
        pivotindex=start+count;
        int temp=Prices[start];
        Prices[start]=Prices[pivotindex];
        Prices[pivotindex]=temp;
        int i=start;
        int j=end;
        while(i<pivotindex && j>pivotindex){
            while (Prices[i]<Prices[pivotindex]){
                i++;
            }
            while (Prices[j]>Prices[pivotindex]){
                j--;
            }
            if(i<pivotindex && j>pivotindex){
                int temp1=Prices[i];
                Prices[i]=Prices[j];
                Prices[j]=temp1;
            }
        }
        return pivotindex;

    }
    public static void quicksort(int []Prices,int start,int end){
        if(start>=end)return;
        int pivot=partition(Prices,start,end);
        quicksort(Prices,start,pivot-1);
        quicksort(Prices,pivot+1,end);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number Of Books");
        int n=sc.nextInt();
        int []Prices=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Price of Product"+ i);
            Prices[i]=sc.nextInt();
        }
        System.out.println("Prices of Products Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(Prices[i]+" ");
        }
        System.out.println();
        quicksort(Prices,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(Prices[i]+" ");
        }


    }
}
