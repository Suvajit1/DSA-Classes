package Graph;

// Disjoint Set Data Structure

public class Classroom7 {
    static int n = 8;
    static int par[];
    static int rank[];


    public static void init(){
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

    public static void main(String[] args) {
        init();

        union(1,3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(5));
        union(1, 5);

        System.err.println(find(4));

        union(0, 7);
        System.err.println(find(7));
    }
}
