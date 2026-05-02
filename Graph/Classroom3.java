package Graph;

import java.util.ArrayList;

public class Classroom3 {
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

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean pathVis[] = new boolean[graph.length];

        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, i, -1, vis, pathVis)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, boolean[] pathVis){

        vis[curr] = true;
        pathVis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // neighbour = e.dest

            if(!vis[e.dest]){ // unvisited
                if(detectCycleUtil(graph, e.dest, curr, vis, pathVis)){
                    return true;
                }
            }

            // visited
            else if(pathVis[e.dest] && e.dest != par){
                return true;
            }
        }

        pathVis[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 10;
        int edgeList[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 6}, {2, 5}, {5, 4}, {1, 7}, {7, 8}, {8, 9}, {9, 7}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        System.out.println(detectCycle(graph));
    }
}
