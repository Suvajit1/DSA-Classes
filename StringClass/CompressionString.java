package StringClass;

public class CompressionString {
    public static String check(String str){
        char ch=str.charAt(0);
        String newstr="";
        int c=1;
        for(int i=1;i<str.length();i++)
        {
            if(str.charAt(i)==ch)
            {
                c++;   
            }
            else
            {   if(c>1){
                    newstr=newstr+ch+c;
                    c=1;
                    ch=str.charAt(i);
                }
                else{
                    newstr=newstr+ch;
                    c=1;
                    ch=str.charAt(i);
                }
            }   
        }
        if(c>1)
            return newstr+ch+c;
        else
            return newstr+ch;

    }
    public static void main(String[] args) {
        String str="aaabaaaccddddaa";
        System.out.println(check(str));
    }
}
