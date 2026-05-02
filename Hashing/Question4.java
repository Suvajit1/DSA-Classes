package Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class Question4 {
    public static void main(String[] args) {
        // Union and Intersection
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();

        for(int i : arr1){
            A.add(i);
        }

        for(int j : arr2){
            B.add(j);
        }

        // System.out.println(A);
        ArrayList<Integer> intersection = new ArrayList<>();
        for(Integer j : B){
            if(A.contains(j)){
                intersection.add(j);
            }
        }

        System.out.println(intersection);

        // Union
        for(int j : arr2){
            A.add(j);
        }
        System.out.println(A);
    }
}
