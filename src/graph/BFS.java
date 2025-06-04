package graph;

import java.util.*;
public class BFS {
    private List<Integer> bfsGraph(int V, List<Integer>[] adj ){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        q.add(1);
        visited[1]=true;
        List<Integer> ans=new ArrayList<>();


        while(!q.isEmpty()){
            int temp=q.poll();
            ans.add(temp);
            List<Integer> l=adj[temp];
            for(int i=0;i<l.size();i++){//enchanced for loop can be used
                int item=l.get(i);
                if(visited[item]==false){
                    q.add(item);
                    visited[item]=true;
                }

            }
        }
        System.out.println(ans);
        return ans;

    }

    public static void main(String[] args) {
        List<Integer>[] adj=new ArrayList[5];
        for(int i=0;i<5;i++){
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

        BFS obj=new BFS();
        obj.bfsGraph(5, adj);



//        adj[2]={1,3};
//        adj[3]={2,4};
//        adj[4]={1,3};
    }
}
