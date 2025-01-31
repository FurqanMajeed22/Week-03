package heapsort.jobapplications;

import java.util.Scanner;

public class JobApplications {
    public static  void heapify(int []arr,int index,int n){
        int largestindex=index;
        int leftindex=2*index+1;
        int rightindex=2*index+2;
        if(leftindex<n  && arr[leftindex]>arr[largestindex]){
            largestindex=leftindex;
        }
        if(rightindex<n && arr[rightindex]>arr[largestindex]){
            largestindex=rightindex;
        }
        if(largestindex!=index){
            int temp=arr[largestindex];
            arr[largestindex]=arr[index];
            arr[index]=temp;
            heapify(arr,largestindex,n);
        }
    }
    public static void heapsort(int[] arr, int size) {
        // Build max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, i, size);
        }
        // Extract elements from heap one by one
        for (int i = size - 1; i > 0; i--) {
            // Swap current root with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Number of Job Applications");
        int n=sc.nextInt();
        int []Salaries=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Salary Demand of Job Application: "+i);
            Salaries[i]=sc.nextInt();
        }
        System.out.println("Salaries Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(Salaries[i]+" ");
        }
        System.out.println();
        int size=Salaries.length;
        heapsort(Salaries,size);
        System.out.println("Salaries After Sorting");
        for(int i=0;i<n;i++){
            System.out.print(Salaries[i]+" ");
        }


    }
}
