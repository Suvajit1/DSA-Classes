package StringClass;

public class Classroom {
    public static void main(String[] args) {
        // String str1 = "apple";
        // String str2 = "apple";
        // String str3 = new String("apple");
        // String str4 = new String("apple");

        // System.out.println(str1==str2); // true
        // System.out.println(str1==str3); // false
        // System.out.println(str3==str4); // false

        StringBuilder sb = new StringBuilder();

        for(char ch ='a'; ch<='z'; ch++){
            sb.append(ch);
        }

        System.out.println(sb);
    }
}
