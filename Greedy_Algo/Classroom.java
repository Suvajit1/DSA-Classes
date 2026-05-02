package Greedy_Algo;

import java.util.ArrayList;
import java.util.Collections;

public class Classroom {
    static class Job implements Comparable<Job>{
        int deadline;
        int profit;
        
        public Job(int deadline, int profit){
            this.deadline = deadline;
            this.profit = profit;
        }

        public String toString(){
            return "("+this.deadline+", "+this.profit+")";
        }

        // @Override
        // public int compareTo(Job obj){
        //     return this.profit - obj.profit; // asc order
        // }

        @Override
        public int compareTo(Job obj){
            return obj.profit - this.profit; // desc order
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{2,80}, {2,22}, {2,10}, {4,25}, {4,20}, {5,60}, {6,70}, {6,65}};

        ArrayList<Job> jobList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            jobList.add(new Job(arr[i][0], arr[i][1]));
        }
        System.out.println(jobList);

        // Collections.sort(jobList, (job1, job2) -> job1.profit - job2.profit ); //asc

        // System.out.println(jobList);

        // Collections.sort(jobList, (job1, job2) -> job2.profit - job1.profit ); //desc

        // System.out.println(jobList);

        Collections.sort(jobList);
        System.out.println(jobList);

        Collections.sort(jobList, Collections.reverseOrder());
        System.out.println(jobList);

    }
}
