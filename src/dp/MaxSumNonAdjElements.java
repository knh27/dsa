package dp;
import java.util.*;
public class MaxSumNonAdjElements {
    int findMaxSum(int arr[]) {
        // code here
        int[] dp=new int[arr.length];
        Arrays.fill(dp, -1);
        return f(arr.length-1, arr, 0,dp);
    }

    int f(int idx, int[] arr, int sum, int[] dp){
        if(idx<0) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int pick=sum+arr[idx]+f(idx-2, arr, sum, dp);
        int nonPick=sum+f(idx-1, arr, sum, dp);

        return dp[idx]=Math.max(pick, nonPick);
    }
}
