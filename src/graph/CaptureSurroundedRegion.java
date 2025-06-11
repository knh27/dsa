package graph;
import java.util.*;

public class CaptureSurroundedRegion {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                q.add(new Pair(i,0));
                vis[i][0]=true;
            }
            if(board[i][n-1]=='O'){
                q.add(new Pair(i,n-1));
                vis[i][n-1]=true;
            }
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                q.add(new Pair(0,i));
                vis[0][i]=true;
            }
            if(board[m-1][i]=='O'){
                q.add(new Pair(m-1,i));
                vis[m-1][i]=true;
            }
        }

        int[][] dir={{0,1}, {1,0}, {-1,0}, {0, -1}};
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int r=temp.row;
            int c=temp.col;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if((nr>=0&&nr<m&&nc>=0&&nc<n)&&(board[nr][nc]=='O' && !vis[nr][nc])){
                    vis[nr][nc]=true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
}


/*

class Solution {
    static char[][] fill(char mat[][]) {
        // code here

        int n=mat.length;
        int m=mat[0].length;
        int[][] dir={{0,1}, {1,0}, {-1,0}, {0, -1}};
        boolean[][] vis=new boolean[n][m];

        for(int i=0;i<m;i++){
            if(mat[0][i]=='O'){
                if(!vis[0][i]){
                    dfs(0, i, mat, vis, dir);
                }

            }

            if(mat[n-1][i]=='O'){
                if(!vis[n-1][i]){
                    dfs(n-1, i, mat,vis, dir);
                }

            }
        }

        for(int i=0;i<n;i++){
            if(mat[i][0]=='O'){
                if(!vis[i][0]){
                    dfs(i, 0, mat, vis, dir);
                }

            }

            if(mat[i][m-1]=='O'){
                if(!vis[i][m-1]){
                    dfs(i, m-1 ,mat, vis, dir);
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    mat[i][j]='X';
                }
            }
        }
         return mat;





    }

    public static void dfs(int r, int c, char[][]a, boolean[][] vis, int[][] dir){
            vis[r][c]=true;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if((nr>=0&&nr<a.length&&nc>=0&&nc<a[0].length)&&(a[nr][nc]=='O') &&(!vis[nr][nc])){
                    dfs(nr, nc, a,vis,dir);
                }
            }

    }


}

*/