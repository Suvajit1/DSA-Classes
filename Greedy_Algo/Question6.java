package Greedy_Algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question6 {
    // Job sequensing problem

    static class Job{
        int idx;
        int deadline;
        int profit;
        
        public Job(int idx, int deadline, int profit){
            this.idx = idx;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2,80}, {6,65}, {6,70}, {5,60}, {2,22}, {4,25}, {2,10}, {4,20}};
        ArrayList<Job> jobList = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            jobList.add(new Job(i, arr[i][0], arr[i][1]));
        }

        // 1. Sort
        // 2. maxDeadLine
        // 3. profit

        Collections.sort(jobList,(a,b)-> b.profit-a.profit); // desc

        int maxDeadLine = 0;
        for(int i=0; i<arr.length; i++){
            maxDeadLine = Math.max(maxDeadLine, arr[i][0]);
        }

        int jobSqn[] = new int[maxDeadLine+1];
        Arrays.fill(jobSqn, -1);
        
        int maxProfit = 0;
        for(int i=0; i<jobList.size(); i++){
            Job job = jobList.get(i); // most profitable job
            int idx = job.idx;
            int dl = job.deadline;
            int profit = job.profit;
            for(int j=dl; j>=1; j--){
                if(jobSqn[j] == -1){
                    jobSqn[j] = idx;
                    maxProfit += profit;
                    break;
                }
            }
        }

        for(int i=0; i<jobSqn.length; i++){
            System.out.print(jobSqn[i]+", ");
        }

        System.out.println("\nMax. profit "+maxProfit);

    }
}
