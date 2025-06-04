package graph;
import java.util.*;

public class MinimumEffortPath {
    static class Triplet{
        int dif;
        int row;
        int col;
        Triplet(int dif, int row, int col){
            this.dif=dif;
            this.row=row;
            this.col=col;
        }
    }
    public static int minimumEffortPath(int[][] heights) {
        // code here
        int rows=heights.length;
        int columns=heights[0].length;
        int[][] diff=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                diff[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Triplet> pq=new PriorityQueue<>((x,y)->x.dif-y.dif);
        pq.add(new Triplet(0, 0,0));
        int[][] dir={{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(pq.size()!=0){
            Triplet temp=pq.poll();
            int dif=temp.dif;
            int r=temp.row;
            int c=temp.col;

            if(r==rows-1 && c==columns-1) return dif;

            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0&&nc>=0&&nr<rows&&nc<columns){
                    int newEffort=Math.max(
                            Math.abs(heights[r][c]-heights[nr][nc]), dif
                    );
                    if(newEffort<diff[nr][nc]){
                        diff[nr][nc]=newEffort;
                        pq.add(new Triplet(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;

    }
}
