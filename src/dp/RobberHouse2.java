package dp;
import java.util.*;

public class RobberHouse2 {
    int maxValue(int[] arr) {
        // code here
        int[] dp=new int[arr.length];
        Arrays.fill(dp, -1);
        int res1= f(arr.length-1,1, arr, 0,dp);
        Arrays.fill(dp, -1);
        int res2=f(arr.length-2,0, arr, 0, dp);
        return Math.max(res1, res2);
    }
    int f(int idx,int lastIdx, int[] arr, int sum, int[] dp){
        if(idx<lastIdx) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int pick=sum+arr[idx]+f(idx-2,lastIdx ,arr, sum, dp);
        int nonPick=sum+f(idx-1, lastIdx, arr, sum, dp);

        return dp[idx]=Math.max(pick, nonPick);
    }
}
