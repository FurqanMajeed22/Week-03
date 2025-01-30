package stackandqueue.circulartourproblem;

public class CircularTourProblem {
    public static int tour(int p[], int cost[])
    {
        int defict=0;
        int balance=0;
        int start=0;
        for(int i=0;i<p.length;i++){
            balance+=p[i]-cost[i];
            if(balance<0){
                defict+=balance;
                start=i+1;
                balance=0;
            }
        }
        if(defict+balance>=0){
            return start;
        }else{
            return -1;
        }

    }
    public static void main(String[] args) {
        int []gas={4, 5, 7, 4};
        int []cost= {6, 6, 3, 5};
        int ans=tour(gas,cost);
        System.out.println(ans);


    }
}
