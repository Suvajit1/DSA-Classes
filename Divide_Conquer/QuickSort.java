package Divide_Conquer;

public class QuickSort {
    public static void quickSort(int arr[], int low, int high){
        if(low>=high){
            return;
        }
        int partidx = partify(arr, low, high);
        quickSort(arr, low, partidx-1);
        quickSort(arr, partidx+1, high);
    }

    public static int partify(int arr[], int low, int high){
        int pivot = arr[low];
        int i=low, j=high;

        while (i<j) {
            while (i<=high && arr[i] <= pivot) {
                i++;
            }
            while (j>=low && pivot < arr[j]) {
                j--;
            }

            if(i<j){ // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;                
            }
        }

        //swap pivot = arr[low], arr[j]
        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3, 8};

        MergeSort.print(arr);
        quickSort(arr, 0, arr.length-1);
        MergeSort.print(arr);
    }
}
