package mergesort.bookprice;

import java.util.ArrayList;
import java.util.Scanner;


public class BookPrice {
    public static  void merge(int Prices[],int start,int mid,int end){
        ArrayList<Integer>arr=new ArrayList<>();
        int left=start;
        int right=mid+1;
        while(left<=mid && right<=end){
            if(Prices[left]<Prices[right]){
                arr.add(Prices[left]);
                left++;
            }else{
                arr.add(Prices[right]);
                right++;
            }
        }
        while(left<=mid){
            arr.add(Prices[left]);
            left++;

        }
        while(right<=end){
            arr.add(Prices[right]);
            right++;
        }
        for(int i=start;i<=end;i++){
            Prices[i]=arr.get(i-start);
        }
    }
    public static void mergesort(int Prices[],int start,int end){
        if(start>=end)return;
        int mid=(start+end)/2;
        mergesort(Prices,start,mid);
        mergesort(Prices,mid+1,end);
        merge(Prices,start,mid,end);


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number Of books");
        int n=sc.nextInt();
        int []Prices=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Price of Book "+ i);
            Prices[i]=sc.nextInt();
        }
        System.out.println("Prices Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(Prices[i]+" ");
        }
        System.out.println();
        System.out.println("After Sorting");
        mergesort(Prices,0,n-1);
        for(int i=0;i<n;i++){
            System.out.print(Prices[i]+" ");
        }

    }
}
