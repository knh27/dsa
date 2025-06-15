package dp;

public class FrogJumpEnergy {
    int minCost(int[] height) {
        // code here
        int[] dp=new int[height.length];
        for(int i=0;i<dp.length;i++)dp[i]=Integer.MAX_VALUE;
        int n=height.length-1;
        return fun_dp(n,height,dp);


    }

    int fun_dp(int n, int[] height, int[] dp){
        if(n==0) return 0;
        if(n==1) return Math.abs(height[1]-height[0]);

        if(dp[n]!=Integer.MAX_VALUE) return dp[n]; 

        int left=fun_dp(n-1, height, dp)+Math.abs(height[n]-height[n-1]);
        int right=fun_dp(n-2, height, dp)+Math.abs(height[n]-height[n-2]);

        dp[n]=Math.min(left, right);
        return dp[n];
    }
}
