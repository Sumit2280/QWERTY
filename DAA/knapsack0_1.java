import java.util.*;
public class knapsack0_1{
    static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static int knapsack(int n,int w,int val[],int wt[],int dp[][]){ 
        if(n==0||w==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(w<wt[n-1]){
            dp[n][w]=knapsack(n-1,w,val,wt,dp);
        }
        else{
            dp[n][w]=max(knapsack(n-1,w,val,wt,dp),knapsack(n-1,w-wt[n-1],val,wt,dp)+val[n-1]);
        }
        return dp[n][w];

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        System.out.println("Enter the weight of the knapsack");
        int w=sc.nextInt();
        int val[]=new int[n];
        System.out.println("Enter the values");
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt(); 
        }
        int wt[]=new int[n];
        System.out.println("Enter the weights");
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(knapsack(n,w,val,wt,dp));
    }
}