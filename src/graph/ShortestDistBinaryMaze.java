package graph;
import java.util.*;
public class ShortestDistBinaryMaze {
    class Solution {
        class Triplet{
            int wt;
            int row;
            int col;
            Triplet(int wt, int row, int col){
                this.wt=wt;
                this.row=row;
                this.col=col;
            }
        }

        int shortestPath(int[][] grid, int[] source, int[] destination) {

            // Your code here
            int m=grid.length;
            int n=grid[0].length;
            int dist[][] =new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
            int i=source[0];
            int j=source[1];

            int dr=destination[0];
            int dc=destination[1];

            Queue<Triplet> q=new LinkedList<>();
            int [][]dir={{0,1}, {1,0}, {-1,0}, {0,-1}};
            q.add(new Triplet(0, i,j));
            while(q.size()!=0){
                Triplet temp=q.poll();
                int dis=temp.wt;
                int r=temp.row;
                int c=temp.col;

                if(dr==r&&dc==c)return dis;

                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0&&nc>=0&&nr<m&&nc<n && (grid[nr][nc]==1&&dist[nr][nc]>dis+grid[nr][nc])){
                        dist[nr][nc]=dis+grid[nr][nc];
                        q.add(new Triplet(dist[nr][nc], nr, nc));
                    }
                }
            }
            return -1;

        }
    }
}
