public class MountainPeakProblem {

    /**
     * public static int check(int arr[] , int a , int i)
     * {
     * if(i==arr.length)
     * {
     * return a;
     * }
     * return check(arr, (int)Math.max(a,arr[i++]), i);
     * }
     **/
    public static int check(int arr[], int i, int j) {
        int mid = (i + j) / 2;
        while (i < j) {
            if (arr[mid] < arr[mid + 1]) {
                i = mid + 1;
                return check(arr, i, j);

            }
            if (arr[mid] > arr[mid + 1]) {
                j = mid;
                return check(arr, i, j);
            }
        }
        return arr[mid];

    }

    public static int peak(int arr[]) {
        int i=0, j=arr.length-1;
        while (i < j) {
            int mid = (i + j) / 2;
            // System.out.println(i+", "+j+", "+mid);
            if (arr[mid] < arr[mid + 1]) {
                i = mid + 1;
            }else{
                j=mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 9, 7, 6 };
        System.out.println(check(arr, 0, arr.length - 1));
        System.out.println(peak(arr));

    }
}