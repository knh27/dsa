package graph;
import java.util.*;

public class EventualSafeState {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];
        int[] check=new int[V];

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,pathVis,check,adj);
            }
        }

        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;

    }

    boolean dfs(int node, boolean[] vis, boolean[] pathVis, int[] check, List<List<Integer>> adj){
        vis[node]=true;
        pathVis[node]=true;

        for(Integer nbr:adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr, vis, pathVis, check,adj)){
                    check[node]=0;
                    return true;
                }
            }
            else if(vis[nbr] && pathVis[nbr]){
                check[node]=0;
                return true;
            }
        }
        check[node]=1;
        pathVis[node]=false;
        return false;

    }
}
