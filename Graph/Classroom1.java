package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom1 {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }


    public static void createGraph(ArrayList<Edge>[] graph, int[][] edgeList){ // Undirected Graph
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edgeList.length; i++){
            int src = edgeList[i][0];
            int dest = edgeList[i][1];

            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src));
        }
    }


    public static void bfs(ArrayList<Edge> graph[], int src){
        boolean[] vis = new boolean[graph.length]; 

        // for(int i=0; i<vis.length; i++){
        //     if(!vis[i]){
        //         bfsUtil(graph, i, vis);
        //     }
        // }
        // System.out.println();

        for(int i=0; i<vis.length; i++){
            int j = (src+i) % vis.length;
            if(!vis[j]){
                bfsUtil(graph, j, vis);
            }
        }

        System.out.println();
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                vis[curr] = true; // step 1 make visited of curr node true

                // Step 2 : add neighbour
                // neigh : e.dest
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    if(!vis[e.dest]){
                        q.add(e.dest);
                    }
                } 

                // Step 3 : print
                System.out.print(curr+" ");
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                dfsUtil(graph, i, vis);
            }
        }

        System.out.println();
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){

        // Step 1 : make visited of curr node true
        vis[curr] = true;

        // Step 2 : print
        System.out.print(curr+" ");

        // Step 3 : visit neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, i, -1, vis)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis){

        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // neighbour = e.dest

            if(!vis[e.dest]){ // unvisited
                if(detectCycleUtil(graph, e.dest, curr, vis)){
                    return true;
                }
            }

            // visited
            else if(vis[e.dest] && e.dest != par){
                return true;
            }

        }

        return false;
    }
    public static void main(String[] args) {
        int V = 10;
        int edgeList[][] = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}, {5, 6}, {7, 8}, {8, 9}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, edgeList);

        // bfs(graph, 0);

        // dfs(graph);

        System.out.println(detectCycle(graph));
    }
}
