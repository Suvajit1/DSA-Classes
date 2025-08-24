package Matrix;

public class Introduction {
    public static void main(String[] args) {
        int mtx[][] = new int[3][];

        mtx[0] = new int[3];
        mtx[1] = new int[2];
        mtx[2] = new int[4];
        
        mtx[0][0] = 1;
        mtx[0][1] = 2;
        mtx[0][2] = 3; 

        mtx[1][0] = 4;
        mtx[1][1] = 5;

        mtx[2][0] = 6;
        mtx[2][1] = 7;
        mtx[2][2] = 8;
        mtx[2][3] = 9;

        for(int i=0; i<mtx.length; i++){
            for(int j=0; j<mtx[i].length; j++){
                System.out.print(mtx[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
