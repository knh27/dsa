package dp;
/*
dp is method for solving complex problem to simple subproblems , solving each subproblem only once and storing their result
*/

public class Main {
    public int fibo(int n){
        if(n==0 || n==1) return n;
        return fibo(n-1)+fibo(n-2);
    }

    public int fibo_dp(int n, int[] dp){
        if(n==0 || n==1)return n;
        if(dp[n]!=-1) return dp[n];
        dp[n]=fibo_dp(n-1, dp)+fibo_dp(n-2, dp);
        return dp[n];
    }

    public int no_stair(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        return no_stair(n-1)+no_stair(n-2) + no_stair(n-3);
    }
    public int no_stair_dp(int n, int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;

        if(dp[n]!=-1) return dp[n];

        dp[n]=no_stair_dp(n-1, dp)+no_stair_dp(n-2, dp) + no_stair_dp(n-3, dp);

        return dp[n];
    }

    public static void main(String[] args) {
        Main obj=new Main();

        int n=100;
        int[] dp=new int[n+1];
        for(int i=0;i<n+1;i++)dp[i]=-1;

//        System.out.println(obj.fibo(n));
//        System.out.println(obj.fibo_dp(n,dp));
        System.out.println(obj.no_stair_dp(n, dp));

    }

}
