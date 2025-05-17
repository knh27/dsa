package graph;
import java.util.*;

public class TopologicalSort {
    public  ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj[u].add(v);
        }

        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i, vis, st, adj);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;

    }

    public void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<Integer>[] adj){
        vis[node]=true;
        for(Integer nbr:adj[node]){
            if(!vis[nbr]){
                dfs(nbr, vis, st, adj);
            }
        }
        st.push(node);
    }
}
