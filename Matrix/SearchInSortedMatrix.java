package Matrix;

public class SearchInSortedMatrix {
    public static boolean searchInSortedMatrix(int mtx[][], int target){
        int i=0, j= mtx.length-1;

        while (i<mtx.length && j>=0) {
            if(target == mtx[i][j]){
                return true;
            }else if(target < mtx[i][j]){
                j--;
            }else{
                i++;
            }
        }

        // for(int i=0; i<mtx.length;){
        //     for(int j=mtx[0].length-1; j>=0;){
        //         if(target == mtx[i][j]){
        //             return true;
        //         }else if(target < mtx[i][j]){
        //             j--;
        //         }else{
        //             i++;
        //         }
        //     }
        // }

        return false;
    }

    public static void main(String[] args) {
        int mtx[][] = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};

        System.out.println(searchInSortedMatrix(mtx, 32));        
        
    }
}
