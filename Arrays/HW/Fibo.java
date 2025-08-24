package Arrays.HW;

public class Fibo {
    
    public static void fibo(int n)
    {  int c=0;
        int a=0;
        int b=1;
        while(n>c)
        {
           System.out.println(a +" "+ b);
           a=b+a;
           b=a-b;
           c++;
        }
    }
    public static void main(String[] args) {
        fibo(10);
    }
}
