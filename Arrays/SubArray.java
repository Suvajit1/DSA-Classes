package Arrays;

public class SubArray {
    // O(n^3)
    public static void subArraySum(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
                minSum = Math.min(minSum, sum);
            }
        }

        System.out.println(maxSum);
        System.out.println(minSum);
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void subArraySumPrefix(int arr[]){
        // prefix arr
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1]+arr[i]; 
        }
        // printArr(prefix);

        // maxSum
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(i==0){
                    maxSum = Math.max(maxSum, prefix[j]);
                }else{
                    maxSum = Math.max(maxSum, prefix[j] - prefix[i-1]);
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void subArraySumKADANES(int[] arr){
        int cs = arr[0];
        int ms = arr[0];
        
        for(int i=1; i<arr.length; i++){
            cs = Math.max(arr[i], cs + arr[i]);
            ms = Math.max(ms, cs);
        }
        System.out.println(ms);
    }

    public static void subArraySumKADANESmin(int[] arr){
        int cs = arr[0];
        int ms = arr[0];
        
        for(int i=1; i<arr.length; i++){
            cs = Math.min(arr[i], cs + arr[i]);
            ms = Math.min(ms, cs);
        }
        System.out.println(ms);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
        int[] brr = {-2, -3, 4, -1, -2, 1, 5, -3};

        // subArraySum(arr);
        // subArraySumPrefix(arr);
        // subArraySumKADANES(arr); // 8
        subArraySumKADANES(brr); // 7

        subArraySumKADANESmin(arr); // -2
        subArraySumKADANESmin(brr); // -5

        int crr[] = {5, 3, 1, 5, 7, 9}; // 1
        subArraySumKADANESmin(crr);

        int[] drr = {5, 3, 1, 0, 5, 7, 9};
        subArraySumKADANESmin(drr); // 0
    }
}
