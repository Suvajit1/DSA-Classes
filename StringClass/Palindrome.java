package StringClass;

public class Palindrome {
    public static boolean pallindrom(String str) {
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }   

    public static void main(String[] args) {
        // String str1 = "apple";
        // String str2 = "apple";
        // String str3 = new String("apple");
        // String str4 = new String("apple");

        // System.out.println(str1==str2); // true
        // System.out.println(str1==str3); // false
        // System.out.println(str3==str4); // false

        String str1 = "racecar";
        String str2 = "madam";
        String str3 = "priyam";

        System.out.println(pallindrom(str1));
        System.out.println(pallindrom(str2));
        System.out.println(pallindrom(str3));
    }
}
