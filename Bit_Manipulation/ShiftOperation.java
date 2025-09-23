package Bit_Manipulation;

public class ShiftOperation {
    public static void main(String[] args) {
        // System.out.println(6<<2);

        // get ith bit

        // int num = 21;
        // int i = 4;

        // int mg = 1<<(i-1);
        // int res = num & mg;
        // System.out.println(res>>(i-1));

        // System.out.println(Integer.toBinaryString(num));


        // // Clear bit 
        // int n = 146;
        // System.out.println(Integer.toBinaryString(n));
        // i=4;
        // int bitMask = ~(1<<i);
        // int newNum = n & bitMask;
        // System.out.println(Integer.toBinaryString(newNum));

        // clear range or bits 

        int num = 4444;
        System.out.println(Integer.toBinaryString(num)); // 1000101011100 // i=3, j=7 // ans = 1000100000100
        int i=3, j=7;

        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        // System.out.println(Integer.toBinaryString(a));
        // System.out.println(Integer.toBinaryString(b));

        int bitMask = a|b;
        // System.out.println(Integer.toBinaryString(bitMask));
        int ans = num & bitMask;
        System.out.println(Integer.toBinaryString(ans));

    }
}
