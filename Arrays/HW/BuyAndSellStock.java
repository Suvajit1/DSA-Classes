public class BuyAndSellStock {
    public static int stock(int ar[])
    {
        int profit=0;
        int bp=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<ar.length;i++)
        {
            if(bp<ar[i])
            {
                profit=ar[i]-bp;
                maxprofit=Math.max(maxprofit,profit);
                
            }
            else
            bp=ar[i];
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int[] ar={7,1,0,5,6,2};
       System.out.println(stock(ar));
        }

}
