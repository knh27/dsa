package dp;

public class MinCostPath2Direction {
    public int minimumCostPath(int[][] grid) {
        // Code here
        int n=grid.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return f(n-1, n-1, grid, dp);
    }

    public int f(int r, int c, int[][] grid, int[][] dp){
        if(r==0 && c==0)return grid[r][c];
        if(r<0 || c<0) return Integer.MAX_VALUE;

        if(dp[r][c]!=-1) return dp[r][c];

        // int left=grid[r][c]+f(r,c-1, grid, dp);
        // int up=grid[r][c]+f(r-1,c, grid, dp);

        int left=f(r,c-1, grid, dp);
        int up=f(r-1,c, grid, dp);

        return dp[r][c]=grid[r][c]+Math.min(left, up);
    }
}
