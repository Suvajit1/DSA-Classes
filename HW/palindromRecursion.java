public class palindromRecursion {
    public static int check(String str, int i, int j, int count) {
        if (i == str.length()) {
            return count;
        }
        if (j > str.length()) {
            return check(str, ++i, i + 1, count);
        } else {
            String s = str.substring(i, j);
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                count++;
            }
            j++;
            return check(str, i, j, count);
        }
    }

    public static void main(String[] args) {
        System.out.println(check("abcab", 0, 1, 0));
    }
}
