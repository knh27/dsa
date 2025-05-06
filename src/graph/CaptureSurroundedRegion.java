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
