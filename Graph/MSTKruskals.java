package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MSTKruskals {
    static int par[];
    static int rank[];

    public static void init(int n){
        par = new int[n];
        rank = new int[n];

        for(int i=0; i<par.length; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }else{
            par[parA] = parB;
        }
    }

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public String toString(){
            return "["+src+", "+dest+", "+wt+"]";
        }
    }

    public static void mstKruskals(int [][] edgeList, int n){
        init(n);
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        int mstCost = 0;
        ArrayList<Edge> mstList = new ArrayList<>();

        int count = 0;

        for(int i=0; count<n-1; i++){
            Edge e = new Edge(edgeList[i][0], edgeList[i][1], edgeList[i][2]);
            if(find(e.src) != find(e.dest)){
                mstCost += e.wt;
                mstList.add(e);
                count++;
                union(e.src, e.dest);
            }
        }
        
        System.out.println(mstList);
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int n = 7;
        int edgeList[][] = {{0, 5, 10}, {5, 4, 25}, {4, 3, 22}, {4, 6, 24}, {3, 6, 18}, {3, 2, 12}, {2, 1, 16}, {1, 6, 14}, {1, 0, 28}};

        mstKruskals(edgeList, n);
    }
}
