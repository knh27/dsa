package graph;

public class NoOfEnclaves {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                q.add(new Pair(i,0));
                vis[i][0]=true;
            }
            if(grid[i][n-1]==1){
                q.add(new Pair(i,n-1));
                vis[i][n-1]=true;
            }
        }

        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                q.add(new Pair(0,i));
                vis[0][i]=true;
            }
            if(grid[m-1][i]==1){
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
                if((nr>=0&&nr<m&&nc>=0&&nc<n)&&(grid[nr][nc]==1 && !vis[nr][nc])){
                    vis[nr][nc]=true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
