package Graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Classroom8 {
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

    public static void sccKosaraju(ArrayList<Edge>[] graph){
        // Step 1 : topo sort 
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i< graph.length; i++){
            if(!vis[i]){
                topoSort(graph, i, vis, s);
            }
        }

        // Step 2 : Reverse Graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[graph.length];

        for(int i=0; i<graph.length; i++){
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 : dfs call
        Arrays.fill(vis,false);
        int sccCount = 0;
        ArrayList<Integer> scc = new ArrayList<>();

        while (!s.isEmpty()) {
            int ver = s.pop();
            if(!vis[ver]){
                dfs(transpose, ver, vis, scc);
                sccCount++;
                System.out.println(scc);
                scc.clear();
            }
        }
        System.out.println(sccCount);
    }   

    public static void topoSort(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topoSort(graph, e.dest, vis, s);
            }
        }
        s.add(curr);
    }

    public static void dfs(ArrayList<Edge>[] transpose, int curr, boolean vis[], ArrayList<Integer> scc){
        vis[curr] = true;
        scc.add(curr);
        for(int i=0; i<transpose[curr].size(); i++){
            Edge e = transpose[curr].get(i);
            if(!vis[e.dest]){
                dfs(transpose, e.dest, vis, scc);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;
        int edgeList[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 4}, {4, 7}, {6, 7}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        sccKosaraju(graph);

    }
}
