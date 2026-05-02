package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Classroom5 {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }


    public static void createDirectedGraph(ArrayList<Edge>[] graph, int[][] edgeList){ // Directed Graph
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edgeList.length; i++){
            int src = edgeList[i][0];
            int dest = edgeList[i][1];
            int wt = edgeList[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void shortestPathDijkstra(ArrayList<Edge>[] graph, int src){
        boolean vis[] = new boolean[graph.length];

        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int curr = pq.remove().node;

            if(!vis[curr]){
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
    
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
    
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        int edgeList[][] = {{0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {4, 3, 2}, {3, 5, 1}, {4, 5, 5}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        shortestPathDijkstra(graph, 0);
    }
}
