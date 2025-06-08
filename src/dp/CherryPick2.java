package dp;

import java.util.*;

public class CherryPick2 {
    public int solve(int n, int m, int grid[][]) {
        // Code here

        int[][][] dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0,0,m-1, grid, n, m, dp);

    }

    public int f(int i, int j1, int j2, int[][]grid, int n, int m,int[][][] dp){

        if(j1<0 || j1>m-1 || j2<0 || j2>m-1) return Integer.MIN_VALUE;

        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else return grid[i][j1]+grid[i][j2];
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int ans=0;
        int mx=Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int newJ1=j1+d1;
                int newJ2=j2+d2;
                if(j1 == j2){
                    ans=grid[i][j1]+f(i+1,newJ1, newJ2, grid, n, m,dp);
                }
                else{
                    ans=grid[i][j1]+grid[i][j2]+f(i+1, newJ1, newJ2, grid, n, m,dp);
                }
                mx=Math.max(ans, mx);
            }
        }
        return  dp[i][j1][j2]= mx;

    }

}
