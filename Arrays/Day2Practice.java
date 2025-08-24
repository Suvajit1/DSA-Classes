package Arrays;

public class Day2Practice {
    public static void swap(int x, int y){
        System.out.println(x);
        System.out.println(y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println(x);
        System.out.println(y);
    }

    public static void pair(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+", "+arr[j]+"), ");
            }
            System.out.println();
        }
    }

    // O(n^3)
    public static void subArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 6;

        swap(a, b);

        System.out.println(a);
        System.out.println(b);

        int arr[] = {2, 4, 6, 8, 10};
        pair(arr);

        subArray(arr);

    }
}
