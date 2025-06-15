package graph;

import java.util.*;

public class DistinctIslands {
    int countDistinctIslands(int[][] grid) {

        int n=grid.length; int m=grid[0].length;
        int dir[][] ={{-1, 0}, {0,1},{1, 0}, {0, -1}};
        Stack<String> st=new Stack<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ArrayList<Character> l=new ArrayList<>();
                    dfs(i,j,i,j,l,vis, dir, grid,st );
                }
            }
        }
        return st.size();
    }

    void dfs(int r, int c, int br, int bc, ArrayList<Character> l, boolean[][] vis, int[][] dir, int[][] grid, Stack<String> st){
        vis[r][c]=true;
        char xr=(char)Math.abs(r-br); char xc=(char)Math.abs(c-bc);
        l.add(xr); l.add(xc);

        for(int[] d:dir){
            int nr=r+d[0];  int nc=c+d[1];
            if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr, nc, r, c, l, vis, dir, grid, st);
            }
        }
        String str=new String(l);
        st.add(str);
    }
}
