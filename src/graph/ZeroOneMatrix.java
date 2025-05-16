package graph;
import java.util.*;

public class ZeroOneMatrix {
    int[][] dir={{0,1}, {0,-1}, {1,0}, {-1, 0}};
    class Pair{
        int row;
        int col;
        // int dis;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
            // this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<Pair>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // if(mat[i][j]!=0){
                if(mat[i][j]==0){
                    q.add(new Pair(i, j));
                    vis[i][j]=true;
                }
            }
        }




        while(!q.isEmpty()){
            Pair temp=q.poll();
            int r=temp.row;
            int c=temp.col;
            int size=q.size();
            int cnt=1;
            // for(int k=0;k<size;k++){
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if((nr>=0&&nr<m && nc>=0&&nc<n) && (!vis[nr][nc])){
                    mat[nr][nc]=mat[r][c]+1;
                    vis[nr][nc]=true;
                    q.add(new Pair(nr, nc));
                }
                // }
            }


        }
        return mat;
    }


    public int[][] updateMatrix2(int[][] mat){
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0){
                    vis[i][j]=true;
                    q.add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Pair temp=q.poll();
            int r=temp.row;
            int c=temp.col;

            int travelR=r;
            int travelC=c;
            int count=0;
            while(mat[travelR][travelC]!=0){
                for(int k=0;k<4;k++){
                    travelR+=dir[k][0];
                    travelC+=dir[k][1];
                    if((travelR>0&&travelC>0&&travelR<m&&travelC<n)){
                        if(mat[travelR][travelC]==0){
                            mat[r][c]=count;
                        }
                        else count++;
                    }
                }
            }

        }
        return mat;
    }
}
