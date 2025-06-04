package dp;

public class CountFriendsPairing {
    class Solution {
        public long countFriendsPairings(int n) {
            // code here
            long[] dp=new long[n+1];
            for(int i=0;i<n+1;i++)dp[i]=-1;
            return friendPairing_dp( n, dp);
        }

        public long friendPairing_dp(int n, long[] dp){
            if(n==1) return 1;
            if(n==2) return 2;

            if(dp[n]!=-1) return dp[n];
            long single=friendPairing_dp(n-1,dp);
            long pair=friendPairing_dp(n-2,dp)*(n-1);
            dp[n]=single+pair;
            return dp[n];
        }
    }
}
