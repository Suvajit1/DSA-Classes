package Greedy_Algo;

import java.util.Comparator;
import java.util.Arrays;

public class Question5 {
    // longest Chain
    public static void main(String[] args) {
        int [][]pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}, {26,40}};

        Arrays.sort(pairs, Comparator.comparingDouble(o->o[1]));

        int len = 1;
        int prevEnd = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            int currStart = pairs[i][0];
            if(currStart >= prevEnd){
                len++;
                prevEnd = pairs[i][1];
            }
        }

        System.out.println(len);
    }
}
