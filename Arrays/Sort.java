package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void print(Integer arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void sortBubble(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int flag = 0;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){ // swap
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                    flag = 1;
                }
            }
            System.out.print("pass "+(i+1)+" : ");
            print(arr);
            if(flag == 0){
                break;
            }
        }
    } 

    public static void SortSelection(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos]>arr[j]){
                    minPos = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;

            // pass
            System.out.print("pass "+(i+1)+" : ");
            print(arr);
        }
    }

    // O(n^2)
    public static void insertionSort(int []arr){
        // int c = 0;  // no.of swap / right shift
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp) {
                arr[j+1] = arr[j];
                j--;
                // System.out.println(++c);
            }
            arr[j+1] = temp;

            // pass
            System.out.print("pass "+(i)+" : ");
            print(arr);
        }
    }

    // count sort
    public static void countSort(int arr[]){
        // step 1
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        // count array
        int []count = new int[max+1];

        // step 2
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        // sorting 
        int j = 0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0) {
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {8, 5, 7, 3, 2};
        sortBubble(arr);
        System.out.println("Bubble Sorted Array : ");
        print(arr);

        int brr[] = {5, 4, 1, 3, 2};
        int crr[] = {1, 2, 4, 3, 6, 5};
        SortSelection(brr);
        System.out.println("Selection Sorted Array : ");
        print(brr);

        SortSelection(crr);
        System.out.println("Selection Sorted Array : ");
        print(crr);

        sortBubble(crr);
        System.out.println("Bubble Sorted Array : ");
        print(crr);

        int []drr = {8, 5, 7, 3, 2};
        insertionSort(drr);
        System.out.println("Insertion sorted array : ");
        print(drr);

        insertionSort(drr);
        System.out.println("Insertion sorted array : ");
        print(drr);


        int err[] = {10, 5, 6, 7, 1, 4, 3};
        print(err);
        Arrays.sort(err);   // O(nlogn)
        System.out.println("Inbuilt sort : ");
        print(err);

        int frr[] = {10, 5, 6, 7, 1, 4, 3};
        print(frr);
        Arrays.sort(frr, 1,5);
        print(frr);


        Integer hrr[] = {3, 1, 2, 0, 1, 5};
        print(hrr);
        Arrays.sort(hrr, Collections.reverseOrder()); // desc
        print(hrr);


        int grr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        print(grr);
        countSort(grr);
        print(grr);
    }
}
