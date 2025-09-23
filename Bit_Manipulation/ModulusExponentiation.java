package Bit_Manipulation;

public class ModulusExponentiation {
    public static int modulus_Expo(int a, int n, int m){
        int ans = 1;
        a = a%m;
        
        while (n>0) {
            if((n&1)==1){ // odd
                ans = (ans*a) % m;
            }
            a = (a*a) % m;
            n = n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 9, n = 5, m = 7;
        System.out.println(modulus_Expo(a, n, m));
    }
}
