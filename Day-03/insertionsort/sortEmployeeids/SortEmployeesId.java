package insertionsort.sortEmployeeids;

import java.util.Scanner;

public class SortEmployeesId {
    public static void insertionsort(int EmployeesId[]){
        int n=EmployeesId.length;
        for(int i=1;i<n;i++){
            int key=EmployeesId[i];
            int j=i-1;
            while(j>=0 && EmployeesId[j]>key   ){
                EmployeesId[j+1]=EmployeesId[j];
                j--;

            }
            EmployeesId[j+1]=key;
        }

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Employees");
        int n=sc.nextInt();
        int []EmployeeID=new int[n];
        for(int i=0;i<n;i++){
            EmployeeID[i]=sc.nextInt();

        }
        System.out.println("Before Sorting");
        for(int i=0;i<n;i++){
            System.out.print(EmployeeID[i]+" ");
        }
        System.out.println();
        insertionsort(EmployeeID);
        System.out.println("After Sorting");
        for(int i=0;i<n;i++){
            System.out.print(EmployeeID[i]+" ");
        }


    }
}
