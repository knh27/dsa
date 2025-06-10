package graph;
import java.util.*;

/*


first approach is also correct and it is done by recursion but giving run time exceeded error for very very larger input so

since graph is directed and acyclic so here, topological sort is used and second one running fine here


*/


public class NoOfPathDAG {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        int n = edges.length;
        ArrayList<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
        }
        boolean[] path = new boolean[V];
        int[] a = {0};
        f(src, dest, path, adj, a);
        return a[0];

    }

    public void f(int node, int dest, boolean[] path, ArrayList<Integer>[] adj, int[] cnt) {
        if (node == dest) {
            cnt[0]++;
            // path[node]=false;
            return;
        }
        path[node] = true;
        for (int nbr : adj[node]) {
            if (!path[nbr]) {
                f(nbr, dest, path, adj, cnt);
            }
        }
        path[node] = false;
    }



    public int countPathsTopo(int[][] edges, int V, int src, int dest) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        // Topological Sort
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stack, adj);
            }
        }

        // DP to count paths
        int[] dp = new int[V];
        dp[src] = 1;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : adj[u]) {
                dp[v] += dp[u];
            }
        }

        return dp[dest];
    }

    void topoSort(int node, boolean[] visited, Stack<Integer> stack, ArrayList<Integer>[] adj) {
        visited[node] = true;
        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                topoSort(nbr, visited, stack, adj);
            }
        }
        stack.push(node);
    }
}



