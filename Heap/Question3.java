package Heap;

import java.util.PriorityQueue;

public class Question3 {
    static class RowInfo implements Comparable<RowInfo>{
    
        int count;
        int idx;

        public RowInfo(int count, int idx){
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(RowInfo r2){
            if(this.count == r2.count){
                return this.idx - r2.idx;
            }
            return this.count - r2.count;
        }
    }

    public static void main(String[] args) {

        int [][]rows = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
        };

        int k = 2;

        PriorityQueue<RowInfo> rowInfos = new PriorityQueue<>();

        for(int i=0; i<rows.length; i++){
            int c = 0;
            for(int j=0; j<rows[0].length; j++){
                c += rows[i][j];
            }
            rowInfos.add(new RowInfo(c, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("R"+rowInfos.remove().idx);
        }
    }
}
