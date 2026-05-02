package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom {
    static class Edge{
        int src;
        int dest;
        // int wt;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
            // this.wt = wt;
        }
    }

    // public static void createGraph(ArrayList<Edge>[] graph){
    //     for(int i=0; i<graph.length; i++){
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(1, 0, 5));
    //     graph[0].add(new Edge(0, 2, -7));

    //     graph[1].add(new Edge(0, 1, 5));
    //     graph[1].add(new Edge(1, 3, 4));

    //     graph[2].add(new Edge(2, 0, -7));
    //     graph[2].add(new Edge(2, 4, 6));

    //     graph[3].add(new Edge(3, 1, 4));
    //     graph[3].add(new Edge(3, 4, -2));
    //     graph[3].add(new Edge(3, 5, 1));


    //     graph[4].add(new Edge(4, 2, 6));
    //     graph[4].add(new Edge(4, 3, -2));
    //     graph[4].add(new Edge(4, 5, 2));


    //     graph[5].add(new Edge(5, 3, 1));
    //     graph[5].add(new Edge(5, 4, 2));
    //     graph[5].add(new Edge(5, 6, -1));


    //     graph[6].add(new Edge(6, 5, -1));
    // }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edgeList){
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

    public static void nearestNeighbour(ArrayList<Edge>[] graph, int ver){

        for(int i=0; i<graph[ver].size(); i++){
            Edge curr = graph[ver].get(i);
            System.out.println(curr.dest);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int src, boolean[] vis){
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

        System.out.println();
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){

        // Step 1 : make visited of curr node true
        vis[curr] =true;

        // Step 2 : print
        System.out.print(curr+" ");

        // Step 3 : visit neighbour
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int edgeList[][] = {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}, {3, 5}, {5, 6}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, edgeList);

        // // Nearest Neighbour
        // int ver = 4;
        // nearestNeighbour(graph, ver);

        int src = 0;
        boolean[] vis = new boolean[V]; // false

        bfs(graph, src, vis);

        boolean[] vis1 = new boolean[V]; // false
        dfs(graph, src, vis1);
        System.out.println();
    }
}
