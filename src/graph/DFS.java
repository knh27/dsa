package graph;
import java.util.*;

public class DFS {
    private List<Integer> dfsGraph(int V, List<Integer>[] adj){
        List<Integer> ans=new ArrayList<>();
        boolean[] visited=new boolean[V];
        int node=adj[1].get(0);
        dfsFun(adj,node, ans, visited);
        System.out.println(ans);
        return ans;
    }

    void dfsFun(List<Integer>[] adj,int node, List<Integer> ans, boolean[] visited){
        visited[node]=true;
        ans.add(node);
        for(Integer val:adj[node]){
            if(!visited[val]){
                dfsFun(adj, val, ans, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS obj=new DFS();
        List<Integer>[] adj=new ArrayList[5];
        for(int i=1;i<5;i++){
            adj[i]=new ArrayList<>();
        }
        adj[1].add(2);
        adj[1].add(4);

        adj[2].add(1);
        adj[2].add(3);

        adj[3].add(2);
        adj[3].add(4);

        adj[4].add(3);
        adj[4].add(1);

        obj.dfsGraph(5,adj);
    }
}
