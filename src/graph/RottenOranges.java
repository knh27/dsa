package graph;
import java.util.*;
public class RottenOranges {
    class Pair {
        int col;
        int row;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = 0;

        Queue<Pair> q = new LinkedList<Pair>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // row=i;
                    // col=j;
                    // break; donot select only single rotten orange,,,there can be multiple oranges
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int time=-1;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Pair temp = q.poll();
                int r = temp.row;
                int c = temp.col;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if ((nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length) && (grid[nr][nc] == 1)) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new Pair(nr, nc));
                    }
                }
            }

        }

        // int ans = bfs(row, col, grid);
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (grid[i][j] == 1) {
        //             return -1;
        //         }
        //     }
        // }
        // return ans;
        if(fresh==0) return time;
        else return -1;

    }

    // int bfs(int row, int col, int[][] grid){
    //     Queue<Pair> q=new LinkedList<Pair>();
    //     q.add(new Pair(row, col));
    //     int[][] dir={ {0,1}, {1,0}, {-1, 0}, {0, -1}};

    //     while(!q.isEmpty()){
    //         Pair temp=q.poll();
    //         int r=temp.row;
    //         int c=temp.col;
    //         int c=0;
    //         for(int i=0;i<4;i++){
    //             int nr=r+dir[i][0];
    //             int nc=c+dir[i][1];
    //             if((nr>=0&&nc>=0 && nr<grid.length&&nc<grid[0].length) && (grid[nr][nc]==1)){
    //                 grid[nr][nc]=2;
    //                 q.add(new Pair(nr, nc));
    //             }
    //         }
    //         c++;
    //     }
    //     return c;
    // }
}
