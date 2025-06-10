package dp;
import java.util.*;

public class PartitionEqualSubsetSum {
    static boolean equalPartition(int arr[]) {
        // code here
        int n=arr.length;

        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
        if(sum%2!=0) return false;
        else{
            Boolean[][] dp=new Boolean[n][sum/2+1];
            return f(n-1, sum/2, arr, dp);
        }
    }

    static Boolean f(int i, int tar, int[] a, Boolean[][]dp){
        if(i==0){
            if(tar==a[0]) return true;
            else return false;
        }
        if(tar==0) return true;

        if(dp[i][tar]!=null) return dp[i][tar];
        boolean notTake=f(i-1, tar, a, dp);

        boolean take=false;
        if(tar>=a[i]){
            take=f(i-1, tar-a[i], a, dp);
        }

        return dp[i][tar]= (take||notTake);
    }
}
