// package Greedy_Algo;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Collection;

// class Job implements Comparable<Job>{
//     int id;
//     int deadline;
//     int profit;

//     Job(int id, int deadline, int profit){
//         this.id = id;
//         this.deadline = deadline;
//         this.profit = profit;
//     }

//     public int compareTo(Job a){
//         return this.profit -a.profit;
//     }

//     public String toString(){
//         return "("+this.id+", "+this.deadline+", "+this.profit+")";
//     }
// }


// class Jobs{
//     int id;
//     int deadline;
//     int profit;

//     Jobs(int id, int deadline, int profit){
//         this.id = id;
//         this.deadline = deadline;
//         this.profit = profit;
//     }

//     public String toString(){
//         return "("+this.id+", "+this.deadline+", "+this.profit+")";
//     }
// }

// public class Classroom1 {
//     public static void main(String[] args) {
//         int[][] arr = {{2,80}, {2,12}, {1,10}, {4,25}, {4,20}, {5,60}, {6,70}, {6,65}};

//         ArrayList<Jobs> jobSqn = new ArrayList<>();
//         for(int i=0; i<arr.length; i++){
//             jobSqn.add(new Jobs(i, arr[i][0], arr[i][1]));
//         }

//         System.out.println(jobSqn);

//         // Collections.sort(jobSqn);
//         // Collections.sort(jobSqn, Comparator.reverseOrder());
//         // Collections.sort(jobSqn, Collections.reverseOrder());


//         // Collections.sort(jobSqn, (a,b)->a.profit-b.profit);
//         Collections.sort(jobSqn, (a,b)->b.profit-a.profit);

//         System.out.println(jobSqn);


//         // max profit
//         // 1. sort
//         // 2. maxDeadline
//         // 3. maxProfit
//         int maxDeadline = 0;
//         for(int i=0; i<arr.length; i++){
//             maxDeadline = Math.max(maxDeadline, arr[i][0]);
//         }

//         // System.out.println(maxDeadline);

//         int[] map = new int[maxDeadline+1];
//         Arrays.fill(map, -1);

//         // for(int i=0; i<map.length; i++){
//         //     System.out.println(map[i]);
//         // }

//         // ArrayList<Jobs> jobsDoneSqn = new ArrayList<>();
//         int profit = 0;
//         for(int i=0; i<jobSqn.size(); i++){
//             Jobs job = jobSqn.get(i); // maxx profit job
//             int dl = job.deadline;
//             for(int j=dl; j>=0; j--){
//                 if(map[j]==-1){
//                     map[j]=job.id;
//                     profit += job.profit;
//                     break; 
//                 }
//             } 
//         }

//         System.out.println(profit);
//         for(int i=0; i<map.length; i++){
//             System.out.print(map[i]+", ");
//         }
//         System.out.println();
//     }
// }
// package Greedy_Algo;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Collection;

// class Job implements Comparable<Job>{
//     int id;
//     int deadline;
//     int profit;

//     Job(int id, int deadline, int profit){
//         this.id = id;
//         this.deadline = deadline;
//         this.profit = profit;
//     }

//     public int compareTo(Job a){
//         return this.profit -a.profit;
//     }

//     public String toString(){
//         return "("+this.id+", "+this.deadline+", "+this.profit+")";
//     }
// }


// class Jobs{
//     int id;
//     int deadline;
//     int profit;

//     Jobs(int id, int deadline, int profit){
//         this.id = id;
//         this.deadline = deadline;
//         this.profit = profit;
//     }

//     public String toString(){
//         return "("+this.id+", "+this.deadline+", "+this.profit+")";
//     }
// }

// public class Classroom1 {
//     public static void main(String[] args) {
//         int[][] arr = {{2,80}, {2,12}, {1,10}, {4,25}, {4,20}, {5,60}, {6,70}, {6,65}};

//         ArrayList<Jobs> jobSqn = new ArrayList<>();
//         for(int i=0; i<arr.length; i++){
//             jobSqn.add(new Jobs(i, arr[i][0], arr[i][1]));
//         }

//         System.out.println(jobSqn);

//         // Collections.sort(jobSqn);
//         // Collections.sort(jobSqn, Comparator.reverseOrder());
//         // Collections.sort(jobSqn, Collections.reverseOrder());


//         // Collections.sort(jobSqn, (a,b)->a.profit-b.profit);
//         Collections.sort(jobSqn, (a,b)->b.profit-a.profit);

//         System.out.println(jobSqn);


//         // max profit
//         // 1. sort
//         // 2. maxDeadline
//         // 3. maxProfit
//         int maxDeadline = 0;
//         for(int i=0; i<arr.length; i++){
//             maxDeadline = Math.max(maxDeadline, arr[i][0]);
//         }

//         // System.out.println(maxDeadline);

//         int[] map = new int[maxDeadline+1];
//         Arrays.fill(map, -1);

//         // for(int i=0; i<map.length; i++){
//         //     System.out.println(map[i]);
//         // }

//         // ArrayList<Jobs> jobsDoneSqn = new ArrayList<>();
//         int profit = 0;
//         for(int i=0; i<jobSqn.size(); i++){
//             Jobs job = jobSqn.get(i); // maxx profit job
//             int dl = job.deadline;
//             for(int j=dl; j>=0; j--){
//                 if(map[j]==-1){
//                     map[j]=job.id;
//                     profit += job.profit;
//                     break; 
//                 }
//             } 
//         }

//         System.out.println(profit);
//         for(int i=0; i<map.length; i++){
//             System.out.print(map[i]+", ");
//         }
//         System.out.println();
//     }
// }
