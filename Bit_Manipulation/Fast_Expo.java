package Bit_Manipulation;

public class Fast_Expo {
    public static int fastExpo(int a, int n){
        int ans = 1;
        
        while (n>0) {
            if((n&1) == 1){ // lsb = 1
                ans = ans*a;
            }  
            a=a*a;
            n = n>>1;
        }

        return ans;
    }
    public static void main(String[] args) {
        int a=2, n=10;

        System.out.println(fastExpo(a, n));
    }
}
