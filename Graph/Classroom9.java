package Graph;

import java.util.ArrayList;

public class Classroom9 {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createUndirectedGraph(ArrayList<Edge>[] graph, int[][] edgeList){ 
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

    public static void tarjanBridge(ArrayList<Edge>[] graph){
        int V = graph.length;
        boolean vis[] = new boolean[V];
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, -1, i, time, vis, dt, low);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int par, int curr, int time, boolean[] vis, int[] dt, int[] low){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, curr, e.dest, time, vis, dt, low);
                low[curr] = Math.min(low[curr], low[e.dest]); // backtracking
                // Bridge Condition
                if(dt[curr] < low[e.dest]){
                    System.out.println("Bridge : ("+ curr+", "+e.dest+")");
                }
            }
            else if(vis[e.dest] && e.dest != par){  // for already visited node
                low[curr] = Math.min(low[curr], dt[e.dest]);
                 // low[curr] = Math.min(low[curr], low[e.dest]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 12;
        int edgeList[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {3, 4}, {4, 5}, {5, 6},
                            {6, 7}, {7, 8}, {5, 8}, {7, 9}, {9, 10}, {10, 11}, {9, 11}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createUndirectedGraph(graph, edgeList);

        tarjanBridge(graph);

    }
}
