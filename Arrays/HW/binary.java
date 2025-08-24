package Arrays.HW;

import java.util.*;
public class binary{
   static int[] ar;
   static int start =0;
    static int end;
    public static int search(int n ,int mid)
    {
        if(start>end)
        {
            return -1;

        }
        else if(ar[mid]==n)
        {
            return mid;
        }
      else 
      {
        if(ar[mid]<n)
        {
            start=mid+1;
        }
        if(ar[mid]>n){
            end=mid-1;

        }
        return search(n,(start+end)/2);
      }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter length : ");
        int len=sc.nextInt();
        ar= new int[len];
        end=len-1;
        System.out.println(" enter elemnt : ");
        for(int i=0;i<=end;i++)
        {
         ar[i]=sc.nextInt();
        }
        System.out.println("enter the number to be search ");
        int l=sc.nextInt();
        System.out.println(search(l,(start+end)/2));
    }

    
}
