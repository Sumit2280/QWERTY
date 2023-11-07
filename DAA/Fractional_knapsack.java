import java.util.*;
public class Fractional_knapsack{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=sc.nextInt();
        int val[]=new int[n];
        System.out.println("Enter the values");
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        int weight[]=new int[n];
        System.out.println("Enter the weights");
        for(int i=0;i<n;i++){
            weight[i]=sc.nextInt();
        }
        System.out.println("Enter the weight of the knapsack");
        int w=sc.nextInt();
        // int val[]={60,100,120};
        // int weight[]={10,20,30};
        // int w=50;

        double ratio[][]=new double[val.length][2];

        //find the ratio and add in the 2d array.
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        //sorting of the 2d array using lambda fn.
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        // System.out.println(ratio[0][1]);
        int capacity=w;
        int finalVal=0;
        for(int i=val.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){//include full item
                capacity-=weight[idx];
                finalVal+=val[idx];
            }
            else{//include fractional item
                finalVal+=ratio[i][1]*capacity;
                capacity=0;
                break;
            }
        }
        System.out.println(finalVal);
    }
}