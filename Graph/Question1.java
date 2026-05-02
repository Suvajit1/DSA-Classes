package Graph;

import java.util.ArrayList;

public class Question1 {
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

    public static void allPath(ArrayList<Edge>[] graph, String path, int src, int dest){

        path = path+src;
        
        if(src == dest){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            allPath(graph, path, e.dest, dest);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        int edgeList[][] = {{5, 0}, {5, 2}, {2, 3}, {3, 1}, {0, 3}, {4, 0}, {4, 1}};

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createDirectedGraph(graph, edgeList);

        allPath(graph, "", 5, 1);

    }
}
