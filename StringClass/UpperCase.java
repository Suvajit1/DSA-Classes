package StringClass;

public class UpperCase {
    public static void main(String[] args) {
        String str = "I am a student";

        StringBuffer newStr = new StringBuffer();

        for(int i=0; i<str.length(); i++){

            newStr.append(str.charAt(i));

            if(str.charAt(i)==' '){
                char ch = Character.toUpperCase(str.charAt(i+1));
                newStr.append(ch);
                i++;
            }
        }

        System.out.println(newStr);
    }
}
