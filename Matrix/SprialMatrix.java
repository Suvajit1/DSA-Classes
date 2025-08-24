package Matrix;

public class SprialMatrix {

    public static void print(int[][] mtx){
        for(int i=0; i<mtx.length; i++){
            for(int j=0; j<mtx[0].length; j++){
                System.out.print(mtx[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void printSprial(int mtx[][]){
        int sr = 0;
        int er = mtx.length-1;
        int sc = 0;
        int ec = mtx[0].length-1;

        int total= mtx.length*mtx[0].length;
        int count = 0;

        while (sr<=er && sc<=ec) {     
            // top
            for(int i=sc; i<=ec; i++){
                System.out.print(mtx[sr][i]+"-->");
                count++;
            }
            sr++;
    
            // right
            for(int i=sr; i<=er; i++){
                System.out.print(mtx[i][ec]+"-->");
                count++;
            }
            ec--;
    
            // buttom
            for(int i=ec; i>=sc && total>count; i--){
                System.out.print(mtx[er][i]+"-->");
                count++;
            }
            er--;
    
            // left
            for(int i=er; i>=sr && total>count; i--){
                System.out.print(mtx[i][sc]+"-->");
                count++;
            }
            sc++;
        }
    }

    public static void main(String[] args) {
        int[][] mtx = new int[3][5];

        int val = 1;
        for(int i=0; i<mtx.length; i++){
            for(int j=0; j<mtx[0].length; j++){
                mtx[i][j] = val++;
            }
        }

        print(mtx);

        printSprial(mtx);
        System.out.println();
    }
}
