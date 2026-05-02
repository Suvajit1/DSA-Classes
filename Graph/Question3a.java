package Graph;

import java.util.PriorityQueue;

public class Question3a {

    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        
        public Edge(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Edge e2){
            return this.cost - e2.cost;
        }
    }

    // Prims Algo
    public static void minCostConnectingCities(int[][] cities){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean mstSet[] = new boolean[cities.length];

        int mstCost = 0;

        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove(); 
            if(!mstSet[curr.dest]){
                mstSet[curr.dest] = true;
                mstCost += curr.cost;

                for(int j=0; j<cities[curr.dest].length; j++){
                    int c = cities[curr.dest][j];

                    if(c > 0){
                        pq.add(new Edge(j, c));
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
            
        minCostConnectingCities(cities);
    }
}
