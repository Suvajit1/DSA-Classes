package Graph;

import java.util.ArrayList;

public class Classroom6 {
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

    public static void shortestPathBellManFord(ArrayList<Edge>[] graph, int src){

        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;

        // T.C = O(VE)
        for(int i=0; i<V-1; i++){ // O(v)

            // all edge (u,v) O(E)
            for(int j=0; j<graph.length; j++){
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // relaxtaion
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
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
        int V = 5;
        int edgeList[][] = {{0, 1, 2}, {0, 2, 4}, {1, 2, -4}, {2, 3, 2}, {3, 4, 4}, {4, 1, -1}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        shortestPathBellManFord(graph, 0);
    }
}
