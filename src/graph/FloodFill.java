package graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean[][] visited=new boolean[m][n];
        int orgCol=image[sr][sc];
        dfs(sr, sc, image, color, visited, orgCol);
        return image;
    }

    void dfs(int sr, int sc, int[][] image, int color, boolean[][] visited, int orgCol){
        image[sr][sc]=color;
        visited[sr][sc]=true;
        int[][] dir={{0,1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i=0;i<4;i++){
            int nrow=sr+dir[i][0];
            int ncol=sc+dir[i][1];
            if((nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length) && (image[nrow][ncol]!=color && visited[nrow][ncol]==false && image[nrow][ncol]==orgCol)){
                dfs(nrow, ncol, image, color, visited, orgCol);
            }

        }
    }
}
