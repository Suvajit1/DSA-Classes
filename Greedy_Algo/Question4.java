package Greedy_Algo;

import java.util.Comparator;
import java.util.Arrays;

public class Question4 {
    // Activity Selection
    public static void main(String[] args) {
        int [][] actList = {{0,6}, {1,2}, {3,4}, {5,7}, {5,9}, {8,9}};   // st, et

        int maxAct = 0;
        int[][] activities = new int[actList.length][3]; // act_no, st, et
        for(int i=0; i<actList.length; i++){
            activities[i][0] = i;
            activities[i][1] = actList[i][0]; // start time
            activities[i][2] = actList[i][1]; // end time
        }

        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));

        maxAct = 1;
        int endTime = activities[0][2];
        System.out.print("A"+activities[0][0]+" ");

        for(int i=1; i<actList.length; i++){
            // curr act st >= prev act et 
            if(activities[i][1] >= endTime){
                maxAct++;
                endTime = activities[i][2];
                System.out.print("A"+activities[i][0]+" ");
            }
        }

        System.out.println("\nTotal no. of Activity : "+ maxAct);
    }
}
