package dp;

public class SubSequencesTargetSum {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        Boolean[][] dp=new Boolean[n][sum+1];

        if(f2(n-1, sum , dp, arr)){
            return true;
        }
        else{
            return false;
        }

    }



    static Boolean f2(int i, int tar, Boolean[][]dp, int[] a){
        if(i<0){
            if(tar!=0) return false;
            else return true;
        }
        if(tar==0) return true;

        if(dp[i][tar]!=null) return dp[i][tar];

        boolean notPick=f2(i-1, tar,dp, a);
        boolean pick=false;
        if(tar>=a[i])pick=f2(i-1, tar-a[i], dp, a);
        return dp[i][tar]= (pick || notPick);

    }

}
