package Arrays.HW;

public class e
{
    public static void main(String[] args)
    {
        int arr[]={1,-1,1};
        String s="";
        for(int i=0;i<arr.length-1;i++)
        {
            s=""+arr[i];
            System.out.print(s+"  ");
            for(int j=i+1;j<arr.length;j++)
            {
                s=s+" "+arr[j];
                System.out.print(s+"  ");
            }
         System.out.println();
        }
        System.out.print(arr[arr.length-1]);
    }
}