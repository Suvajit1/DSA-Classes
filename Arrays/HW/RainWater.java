public class RainWater {
    public static void Tw(int h[])
    {
        int[] lmb=new int[h.length];
        int[] rmb= new int[lmb.length];
         //
         lmb[0]=h[0];
         rmb[rmb.length-1]=h[h.length-1];
         for(int i=1;i<h.length;i++)
         {
            lmb[i]=Math.max(lmb[i-1],h[i]);
         }
         for(int i=h.length-2;i>=0;i--)
         {
            rmb[i]=Math.max(rmb[i+1],h[i]);
         }
         int sum=0;
         for(int i=0;i<h.length;i++)
         {
          sum=sum+Math.min(lmb[i],rmb[i])-h[i];
         }
         System.out.println(sum);
         
       
    }
    public static void main(String[] args) {
        int ar[]={4,2,0,6,3,2,5};
        Tw(ar);
    }
}
