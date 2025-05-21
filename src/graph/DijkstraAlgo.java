package graph;
import java.util.*;

public class DijkstraAlgo {
    class Pair implements Comparable<Pair> {
        int dis;
        int node;

        Pair(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }

        public int compareTo(Pair o) {
            if (this.dis != o.dis) return this.dis - o.dis;
            return this.node - o.node;
        }

        // Optional but safe for TreeSet.remove()
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return dis == pair.dis && node == pair.node;
        }

        public int hashCode() {
            return Objects.hash(dis, node);
        }
    }


    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        // int m=edges.length;
        // int n=edges[0].length;

        ArrayList<int[]>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }

        //using PrioriyQueue and Set data structure

        // PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dis-y.dis);
        TreeSet<Pair> st=new TreeSet();

        int[] dist=new int[V];
        for(int i=0;i<V;i++)dist[i]=Integer.MAX_VALUE;

        dist[src]=0;
        // pq.add(new Pair(0, src));

        st.add(new Pair(0,src));
        // while(pq.size()!=0){
        while(st.size()!=0){
            // Pair temp=pq.poll();
            Pair temp=st.pollFirst();
            int dis=temp.dis;
            int node=temp.node;
            for(int[] it:adj[node]){
                int nbr=it[0];
                int wt=it[1];
                if(dis+wt<dist[nbr]){
                    st.remove(new Pair(dist[nbr], nbr));
                    dist[nbr]=dis+wt;
                    // pq.add(new Pair( dis+wt,nbr));
                    st.add(new Pair(dis+wt, nbr));
                }
            }
        }
        return dist;
    }
}
