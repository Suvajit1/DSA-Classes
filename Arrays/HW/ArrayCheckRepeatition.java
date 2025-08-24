public class ArrayCheckRepeatition {
    public static boolean check(int ar[])
    {
        int flag=0;
    for(int i=0;i<ar.length-1;i++)
    {
        for(int j=i+1;j<ar.length;j++)
        {
           if(ar[i]==ar[j])
           {
            flag++;
            break;
           }
        }
    }
    if(flag==0)
    return true;
    else
    return false;

    }
    public static void main(String[] args) {
        int ar[]={1,2,6,3,4,3};
        System.out.println(check(ar));
    }
}
