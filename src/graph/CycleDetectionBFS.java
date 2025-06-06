package graph;
import java.util.*;
public class CycleDetectionBFS {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited=new boolean[V];
        boolean ans=true;
//        for(int i=0;i<V;i++){
//            if(visited[i]==false){
//                ans=checkCycle(i, V, visited, adj);
//            }
//        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
//                if(ans==false) break;
//                ans=checkCycleDFS(i, -1, visited,adj);
                if(checkCycleDFS(i,-1,visited,adj)){
                    return true;
                }
            }
        }
//        return ans;
        return false;
    }

    public boolean checkCycle(int src, int V, boolean[] visited, List<Integer>[] adj){
        visited[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src, -1));
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int node=temp.node;
            int parent=temp.parent;

            for(int item:adj[node]){
                if(visited[item]==false){
                    visited[item]=true;
                    q.add(new Pair(item, node));
                }
                else if(item!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCycleDFS(int src,int par, boolean[] vis, List<Integer>[] adj){
        vis[src]=true;
        for(Integer i:adj[src]){
            if(vis[i]==true && i != par){
                return true;
            }
            else if(checkCycleDFS(i, src, vis, adj)){
                return true;
            }
        }
        return false;
    }


    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] vis=new boolean[V];
        //converting edges into adjency list
        List<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkCycleDFS(adj, vis, i, -1)){
                    return true;
                }
            }

        }


        return false;
    }

    public boolean checkCycleDFS(List<Integer>[] adj, boolean[] vis, int src, int par){
        vis[src]=true;
        for(Integer nbr:adj[src]){
            if(vis[nbr] && nbr!=par){
                return true;
            }
            else if(!vis[nbr]){
                if(checkCycleDFS(adj, vis, nbr, src)) return true;
            }
        }
        return false;
    }

}
