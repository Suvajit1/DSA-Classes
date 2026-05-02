package Backtraking;

public class GridWays {
    public static int ways(int x, int y, int n, int m){
        // base
        if(x==n-1 && y==m-1){
            return 1;
        }else if(x==n-1){
            return ways(x, y+1, n, m);
        }else if(y==m-1){
            return ways(x+1, y, n, m);
        }

        // recursion
        return ways(x, y+1, n, m) + ways(x+1, y, n, m);
    }

    public static void main(String[] args) {
        int n=3, m=3;
        System.out.println(ways(0, 0, n, m));
    }
}
