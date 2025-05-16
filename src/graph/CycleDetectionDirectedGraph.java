package graph;
import java.util.*;

public class CycleDetectionDirectedGraph {
    public boolean isCyclic(int V, int[][] edges) {
        // code here=
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj[u].add(v);
            // adj[v].add(u);

        }

        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj)){
                    return true;
                }
            }
        }
        return false;


    }
    boolean dfs(int node, boolean[] vis, boolean[] pathVis, ArrayList<Integer>[] adj){
        vis[node]=true;
        pathVis[node]=true;
        for(Integer nbr:adj[node]){
            if(!vis[nbr]){
                if(dfs(nbr, vis, pathVis, adj)){

                    return true;
                }
            }
            else if(vis[nbr] && pathVis[nbr]){
                return true;
            }

        }
        pathVis[node]=false;
        return false;
    }
}
