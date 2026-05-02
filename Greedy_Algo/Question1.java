package Greedy_Algo;

import java.util.Arrays;
public class Question1 {
    public static void main(String[] args) {
        int A[] = {1, 2, 3};
        int B[] = {2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum = sum + Math.abs(A[i]-B[i]);
        }

        System.out.println(sum);
    }
}
