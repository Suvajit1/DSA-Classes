package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Classroom4 {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createDirectedGraph(ArrayList<Edge>[] graph, int[][] edgeList){ // Directed Graph
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edgeList.length; i++){
            int src = edgeList[i][0];
            int dest = edgeList[i][1];

            graph[src].add(new Edge(src, dest));
        }
    }

    public static void topoSortDFS(ArrayList<Edge>[] graph){

        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                topoSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println();

    }

    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){

        // step 1 : make visited
        vis[curr] = true;

        // Step 2 : call neighbour (unvisited)
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topoSortUtil(graph, e.dest, vis, s);
            }
        }

        // Step 3 : put in stack
        s.push(curr);

    }

    public static void topoSortBFS(ArrayList<Edge>[] graph){

        int indeg[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
    
        for(int i=0; i<graph.length; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Topo Sort
        int V = 6;
        int edgeList[][] = {{5, 0}, {4, 0}, {5, 2}, {2, 3}, {3, 1}, {4, 1}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        topoSortDFS(graph);

        topoSortBFS(graph);
        System.out.println();

    }
}
