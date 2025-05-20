package graph;
import java.util.*;

public class ShortestPathUndirectedGraphUnitWeights {
    class Pair{
        int node;
        int dist;

        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int V=adj.size();
        int[] dis=new int[V];
        for(int i=0;i<V;i++){
            dis[i]=-1;
        }
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(src, 0));
        dis[src]=0;
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int d=temp.dist;
            int node=temp.node;

            for(int nbr:adj.get(node)){
                if(dis[nbr] == -1){
                    q.add(new Pair(nbr,d+1));
                    dis[nbr]=d+1;
                }

            }
        }
        return dis;



    }
}
