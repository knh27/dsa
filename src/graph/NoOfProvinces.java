package graph;
import java.util.*;
public class NoOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        // ArrayList<Integer>[] adj=new ArrayList[V];
        // for(int i=0;i<V;i++){
        //     adj[i]=new ArrayList<>();
        // }

        // for(int i=0;i<V;i++){
        //     for(int j=0;j<V;j++){
        //         if(isConnected[i][j]==1 && i!=j){
        //             adj[i].add(j);
        //             // adj[j].add(i);
        //         }
        //     }
        // }



        boolean[] isVisited=new boolean[V];
        int c=0;
        for(int i=0;i<V;i++){
            if(isVisited[i]==false){
                c++;
                // dfs(adj, isVisited, i);
                dfs(isConnected, isVisited, i);
            }
        }


        return c;
    }

    // public void dfs(ArrayList<Integer>[] adj, boolean[] isVisited, int node){
    //     isVisited[node]=true;
    //     for(int item:adj[node]){
    //         if(isVisited[item]==false){
    //             dfs(adj, isVisited, item);
    //         }
    //     }

    // }

    public void dfs(int[][] isConnected, boolean[] isVisited, int node){
        isVisited[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isVisited[i]==false && isConnected[node][i]==1){
                dfs(isConnected, isVisited, i);
            }
        }

    }

    public int noOfProvinces(int[][] connected){
         int V=connected.length;
         Queue<Integer> q=new LinkedList<>();
         boolean[] visited=new boolean[V];
         int c=0;
         for(int i=0;i<V;i++){
             if(!visited[i]){
                 q.add(i);
                 visited[i]=true;
                 c++;
                 while(!q.isEmpty()){
                     int node=q.poll();
                     for(int k=0;k<V;k++){
                         if(connected[node][k]==1 && visited[k]==false){
                             q.add(k);
                             visited[k]=true;
                         }
                     }
                 }
             }

         }
         return c;
    }
}
/*
same problem using dfs no of islands


        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        int[][] dir={{-1,0},{-1,1}, {0,1}, {1,1}
        , {1,0}, {1,-1}, {0,-1}, {-1,-1}};

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L' && !vis[i][j]){
                    dfs(i, j, vis, grid, dir);
                    cnt++;
                }
            }
        }
        return cnt;







public void dfs(int r, int c, boolean[][] vis, char[][] grid, int[][]dir){
        vis[r][c]=true;
        for(int k=0;k<8;k++){
            int nr=r+dir[k][0];
            int nc=c+dir[k][1];

            if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length &&
                !vis[nr][nc]&&grid[nr][nc]=='L'
                ){
                    dfs(nr, nc, vis, grid,dir);
                }
            }
    }


*/