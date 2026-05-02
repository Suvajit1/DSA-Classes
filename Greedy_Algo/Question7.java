package Greedy_Algo;

import java.util.Collections;
import java.util.Arrays;

public class Question7 {
    public static void main(String[] args) {
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        // desc 
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int hb = 1, vb = 1;
        int h = 0, v=0;
        int cost = 0; // min

        while (h<costHor.length && v<costVer.length) {
            if(costVer[v] >= costHor[h]){ // vertical cut
                cost += hb*costVer[v];
                vb++;
                v++;
            }else{ // horizontal cut
                cost += vb*costHor[h];
                hb++;
                h++;
            }
        }

        while (h<costHor.length) { //  horizontal cut
            cost += vb*costHor[h];
            hb++;
            h++;
        }

        while (v<costVer.length) {
            cost += hb*costVer[v];
            vb++;
            v++;
        }


        System.out.println(cost);
    }
}
