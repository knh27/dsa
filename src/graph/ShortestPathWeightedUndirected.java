package graph;
import java.util.*;

public class ShortestPathWeightedUndirected {
    class Pair{
        int dis;
        int node;
        Pair(int dis, int node){
            this.dis=dis;
            this.node=node;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<int[]>[] adj=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] it:edges){
            int a=it[0];
            int b=it[1];
            int w=it[2];

            adj[a].add(new int[]{b,w});
            adj[b].add(new int[]{a,w});
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dis-y.dis);
        int[] parent=new int[n+1];
        int[] dist=new int[n+1];
        for(int i=0;i<n+1;i++)dist[i]=Integer.MAX_VALUE;
        pq.add(new Pair(0,1));
        dist[1]=0;
        parent[1]=-1;

        while(pq.size()!=0){
            Pair temp=pq.poll();
            int node=temp.node;
            int dis=temp.dis;
            // if (temp.dis > dist[temp.node]) continue;   // ← skip stale entry
            for(int[] it:adj[node]){
                int nbr=it[0];
                int wt=it[1];
                if(wt+dis<dist[nbr]){
                    dist[nbr]=wt+dis;
                    pq.add(new Pair(dist[nbr], nbr));
                    parent[nbr]=node;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        // System.out.println(dist[n]);
        if (dist[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        int temp=n;
        while(temp!=-1){
            ans.add(0, temp);
            temp=parent[temp];
        }
        ans.add(0,dist[n]);
        return ans;
    }
}
