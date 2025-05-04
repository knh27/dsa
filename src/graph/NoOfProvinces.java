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
}
