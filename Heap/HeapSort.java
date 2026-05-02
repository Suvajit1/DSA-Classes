package Heap;

public class HeapSort {
    public static void heapsort(int arr[]){
        // step 1 - max heap
        for(int i=(arr.length/2); i>=0; i--){
            heapify(arr, i, arr.length);
        }
        // sorting
        for(int n=(arr.length-1); n>=1; n--){
            // swap 
            int temp = arr[0];
            arr[0] = arr[n];
            arr[n] = temp;

            heapify(arr, 0, n);
        }
    }

    public static void heapify(int arr[], int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;

        int maxIdx = i;
        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx = left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }

        // swap
        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 30, 40, 25, 45};
        heapsort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
