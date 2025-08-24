package Arrays;

public class Search {
    // O(n)
    public static int searchElement(int []arr, int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]== key){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int []arr, int key){
        int st = 0;
        int end = arr.length-1;

        while (st<=end) {
            int mid = (st+end)/2;

            if(arr[mid] == key){
                return mid;
            }
            // left half
            else if (key < arr[mid]) {
                end = mid-1;
            }
            else{   // right half
                st = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 1, 11, 8, 5, 6, 2, 10 , 7};

        int idx = searchElement(arr, 15);
        System.out.println(idx);


        int brr[] = {10, 20, 25, 30, 35, 40, 45, 50, 60};
        int idx1 = binarySearch(brr, 35);
        System.out.println(idx1);

        int trr[] = {10};

        System.out.println(binarySearch(trr, 10));

    }
}
