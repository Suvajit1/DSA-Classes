public class ThreeSumZero {
    public static void check(int []ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            for(int j=i;j<ar.length;j++)
            {
                for(int k=j;k<ar.length;k++)
                {
                    if(i!=j && j!=k && i!=k)
                    {
                        if(ar[i]+ar[j]+ar[k]==0)
                        {
                            System.out.println("[" +ar[i] +","+ar[j]+","+ar[k]+"] ");
                        }
                        


                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] ar={-1,0,1,2,-2,3,-4};
        check(ar);
    }
}
