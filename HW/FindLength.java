public class FindLength {
    public static int check(String str) {
        if (str == "")
            return 0;
        else
            return 1 + check(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(check("priyam"));
    }
}
