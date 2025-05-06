package graph;
import java.util.*;

public class CycleDetectionDFS {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){ //loop used for disconnected component
            if(vis[i]==false){
                boolean ans=checkCycleDFS(adj,i,-1, vis);
                if(ans==true) return true;
            }
        }

        return false;
    }


    boolean checkCycleDFS(List<Integer>[] adj, int node, int parent, boolean[] vis){
        vis[node]=true;
        for(int item:adj[node]){
            if(vis[item]==false){
                boolean res=checkCycleDFS(adj, item, node, vis);
                if(res==true) return true;
            }
            else if(vis[item]==true && item!=parent){
                return true;
            }
        }
        return false;
    }
}
