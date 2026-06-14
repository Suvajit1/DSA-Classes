package Graph;

import java.util.ArrayList;

public class Classroom10 {
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

    public static void tarjanAP(ArrayList<Edge>[] graph){
        int V = graph.length;
        boolean vis[] = new boolean[V];
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean AP[] = new boolean[V];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                dfs(graph, -1, i, time, vis, dt, low, AP);
            }
        }

        for(int i=0; i<AP.length; i++){
            if(AP[i]){
                System.out.println("AP : "+ i);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int par, int curr, 
                int time, boolean[] vis, int[] dt, int[] low, boolean[] AP){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        int children = 0;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(e.dest == par){
                continue;
            }else if(vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]); // visited nodes
                // low[curr] = Math.min(low[curr], low[e.dest]);
            }else{
                dfs(graph, curr, e.dest, time, vis, dt, low, AP);
                low[curr] = Math.min(low[curr], low[e.dest]); // backtracking

                if(par != -1 && dt[curr] <= low[e.dest]){
                    AP[curr] = true;
                }
                children++;
            }
        }

        // root checking
        if(par == -1 && children >1){
            AP[curr] = true;
        }
    }

    public static void main(String[] args) {
        int V = 7;
        int edgeList[][] = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 6}, {6, 5}, {5, 2}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createUndirectedGraph(graph, edgeList);

        tarjanAP(graph);

    }
}
