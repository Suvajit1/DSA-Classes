public class RotateArray {

    public static void rotate(int ar[],int target)
    {
        int r[]=new int[ar.length];
        int len=ar.length/2;
        for(int i=0;i<len;i++)
        {
            r[i]=ar[len+i];
            r[len+i]=ar[i];
        }
        int flag=0;
      for(int i=0;i<ar.length;i++)
      {
        if(r[i]==target){
        System.out.println(i);
        flag++;
        break;
        }
      }
      if(flag==0)
     System.out.println("-1");
    }
    public static void main(String[] args) {
        int []ar={4,3,7,1,0,2,5};
        for(int i=0;i<ar.length-1;i++)
       {  
        int minsum=i;
        for(int j=i+1;j<ar.length;j++)
        {
          if(ar[j]<ar[minsum])
          {
            minsum=j;
          }
        }
        int temp=ar[i];
        ar[i]=ar[minsum];
        ar[minsum]=temp;
       } 
       rotate(ar,3) ;
       rotate(ar,10);
    }
}
