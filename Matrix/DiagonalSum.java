package Matrix;

public class DiagonalSum {
    public static int diagonalSum(int mtx[][]){
        int ld = 0;
        int rd = 0;

        for(int i=0; i<mtx.length; i++){
            // ld
            ld+= mtx[i][i];
            // rd
            int j= mtx.length-1-i;
            if(i != j){
                rd += mtx[i][j];
            }
        }
        return ld+rd;
    }

    public static void main(String[] args) {
        int[][] mtx = new int[3][3];

        int val = 1;
        for(int i=0; i<mtx.length; i++){
            for(int j=0; j<mtx[0].length; j++){
                mtx[i][j] = val++;
            }
        }

        System.out.println(diagonalSum(mtx));
    }
}
