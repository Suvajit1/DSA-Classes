public class DigitsToNumber {
    public static String check(int num, String str, String s[]) {
        if (num == 0) {
            return str;
        }
        int dg = num % 10;
        str = s[dg] + " " + str;
        return check(num / 10, str, s);

    }

    public static void main(String[] args) {
        String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        System.out.println(check(2025, " ", str));
    }
}
