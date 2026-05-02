package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
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

    public static void createdGraph(ArrayList<Edge>[] graph, int[][] edgeList){ // Undirected Graph
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edgeList.length; i++){
            int src = edgeList[i][0];
            int dest = edgeList[i][1];
            int wt = edgeList[i][2];

            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));

        }
    }

    static class Triplets implements Comparable<Triplets>{
        int par;
        int node;
        int cost;
        
        public Triplets(int par, int node, int cost){
            this.par = par;
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Triplets t2){
            return this.cost - t2.cost;
        }

        public String toString(){
            return "["+this.par+", "+this.node+", "+this.cost+"]";
        }
    }

    // Prims Algo
    public static void mstPrims(ArrayList<Edge>[] graph){
        PriorityQueue<Triplets> pq = new PriorityQueue<>();
        boolean mstSet[] = new boolean[graph.length];

        ArrayList<Triplets> mstEdgeList = new ArrayList<>();
        int mstCost = 0;

        pq.add(new Triplets(-1, 0, 0));

        while (!pq.isEmpty()) {
            Triplets curr = pq.remove(); // par, node, cost
            if(!mstSet[curr.node]){
                mstSet[curr.node] = true;
                if(curr.par != -1){
                    mstCost += curr.cost;
                    mstEdgeList.add(curr);
                }
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    if(!mstSet[e.dest]){
                        pq.add(new Triplets(curr.node, e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println(mstEdgeList);
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 7;
        int edgeList[][] = {{0, 5, 10}, {5, 4, 25}, {4, 3, 22}, {4, 6, 24}, {3, 6, 18}, {3, 2, 12}, {2, 1, 16}, {1, 6, 14}, {1, 0, 28}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createdGraph(graph, edgeList);
        mstPrims(graph);
    }
}
