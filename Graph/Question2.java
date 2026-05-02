package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question2 {
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

    static class Info {
        int node;
        int cost;
        int step;

        public Info(int node, int cost, int step){
            this.node = node;
            this.cost = cost;
            this.step = step;
        }
    }
    
    public static int chapesstFlight(ArrayList<Edge>[] graph, int src, int dest, int k){
        int dist[] = new int[graph.length];

        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.step > k){
                break;
            }

            for(int i=0; i<graph[curr.node].size(); i++){
                Edge e = graph[curr.node].get(i);

                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v]){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.step+1));
                }
            }
        }

        if(dist[dest]==Integer.MAX_VALUE) {
            return -1;
        } else{
            return dist[dest];
        }

    }

    public static void main(String[] args) {

        int V = 6;
        int[][] flights = {{0, 1, 5}, {0, 4, 2}, {4, 1, 2}, {1, 2, 5}, {1, 5, 1}, {2, 3, 2}, {5, 3, 1}};
        int src = 0, dest = 3, k = 2;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, flights);

        System.out.println(chapesstFlight(graph, src, dest, k));

    }
}
