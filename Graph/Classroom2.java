package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom2 {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }


    public static void createGraph(ArrayList<Edge>[] graph, int[][] edgeList){ // Undirected Graph
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


    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int[] color = new int[graph.length]; 

        Arrays.fill(color, -1);
        
        for(int i=0; i<color.length; i++){
            if(color[i] == -1){
                if(!isBipartiteUtil(graph, color, i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int[] color, int par){
        color[par] = 0;
        Queue<Integer> q = new LinkedList<>();

        q.add(par);

        while (!q.isEmpty()) {
            int curr = q.remove();
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i); // neighbour

                if(color[e.dest] != -1 && color[e.dest] == color[curr]){
                    return false;
                }

                else if(color[e.dest] == -1){
                    color[e.dest] = (color[curr]+1)%2;
                    q.add(e.dest);
                }

            }
        }

        return true;
    }

        public static void main(String[] args) {
        int V = 5;
        int edgeList[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 4}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph, edgeList);

        System.out.println(isBipartite(graph));
    }
}
