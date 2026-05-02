package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Question3 {
    static class Edge implements Comparable<Edge>{
        int dest;
        int wt;

        public Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }

        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    public static void createdGraph(ArrayList<Edge>[] graph, int[][] cities){ // Undirected Graph
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<cities.length; i++){ // i->src
            for(int j=0; j<cities[i].length; j++){
                int c = cities[i][j];
                if(c > 0){
                    graph[i].add(new Edge(j, c));
                }
            }
        }
    }

    // Prims Algo
    public static void minCostConnectingCities(ArrayList<Edge>[] graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean mstSet[] = new boolean[graph.length];

        int mstCost = 0;

        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove(); // par, node, cost
            if(!mstSet[curr.dest]){
                mstSet[curr.dest] = true;
                mstCost += curr.dest;

                for(int i=0; i<graph[curr.dest].size(); i++){
                    Edge e = graph[curr.dest].get(i);
                    if(!mstSet[e.dest]){
                        pq.add(new Edge(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        // Connecting Cities with min cost
        int[][] cities = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}};

    
        int V = cities.length; 

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];    
            
        createdGraph(graph, cities);
        minCostConnectingCities(graph);
    }
}
